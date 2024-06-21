package springpractice.shoppingmall.Service;

import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springpractice.shoppingmall.DTO.*;
import springpractice.shoppingmall.Entity.*;
import springpractice.shoppingmall.Repository.OrderProductRepository;
import springpractice.shoppingmall.Repository.OrderRepository;
import springpractice.shoppingmall.Repository.ProductRepository;
import springpractice.shoppingmall.Repository.UserRepository;

import java.rmi.NoSuchObjectException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    OrderRepository orderRepository;
    ProductRepository productRepository;
    OrderProductRepository orderProductRepository;
    UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, OrderProductRepository orderProductRepository,UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderProductRepository = orderProductRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> saveOrder(SaveOrderDto dto) {
        List<Long> productIds = dto.getProducts().stream().map(p -> p.getProductId()).toList();
        for (Long productId : productIds) {
            Product product = productRepository.findById(productId).orElse(null);
            if (product == null) {
                throw new IllegalArgumentException("없는 상품을 주문할 수 없음");
            }
        }
        User user = userRepository.getReferenceById(dto.getUserId());
        Order order = new Order();
        for (OrderProductDto orderProduct : dto.getProducts()) {
            OrderProduct product = new OrderProduct(
                    orderProduct.getProductId(),
                    orderProduct.getPrice(),
                    orderProduct.getQuantity());
                    order.addOrderProduct(product);
        }
        order.setUser(user);
        user.getOrder().add(order);
        orderRepository.save(order);
        return ResponseEntity.ok("저장됨");
    }


    public ResponseEntity<OrderDetailResponseDto> findOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("해당 주문이 존재하지 않습니다."));
        List<OrderProductDto> orderProduct = order.getProducts().stream().map(p -> new OrderProductDto(p.getId(), p.getPrice(), p.getQuantity())).toList();
        OrderDetailResponseDto orderResponse = new OrderDetailResponseDto(order.getId(), orderProduct, getTotalPrice(order.getId()),order.getUser().getId());
        return ResponseEntity.ok(orderResponse);
    }

    public ResponseEntity<List<OrdersResponseDto>> findAllOrder() {

        List<Order> oder = orderRepository.findAll();
        List<OrderProduct> orderProducts = oder.stream().map(Order::getProducts).flatMap(List::stream).collect(Collectors.toList());

        List<Long> ids = orderProducts.stream().map(p -> p.getProductId()).toList();
        List<Product> products = productRepository.findAllById(ids);

        return ResponseEntity.ok(oder.stream().map(order ->
                new OrdersResponseDto(
                        order.getId(), getTotalPrice(order.getId()),
                        products.stream().map(p -> p.getName()).toList(), OffsetDateTime.now())).toList());

    }


    public Long getTotalPrice(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        Long total = order.getProducts().stream().mapToLong(p -> p.getQuantity() * p.getPrice()).sum();
        return total;
    }

    @Transactional
    public ResponseEntity<String> cancleOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("해당주문이 존재하지 않음"));
        order.deleteOrder();
        return ResponseEntity.ok("주문이 취소되었습니다.");
    }

}
