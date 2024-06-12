package springpractice.shoppingmall.Service;

import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springpractice.shoppingmall.DTO.OrderDetailResponseDto;
import springpractice.shoppingmall.DTO.SaveOrderDto;
import springpractice.shoppingmall.DTO.SaveProductOrderDto;
import springpractice.shoppingmall.Entity.Order;
import springpractice.shoppingmall.Entity.OrderProduct;
import springpractice.shoppingmall.Entity.Product;
import springpractice.shoppingmall.Repository.OrderRepository;
import springpractice.shoppingmall.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepository;
    ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

//    public ResponseEntity<String> saveOrder(SaveOrderDto dto) {
//
//        List<Long> productIds = dto.getProducts()
//                .stream()
//                .map(orderProduct -> orderProduct.getProductId())
//                .toList();
//        for (Long productId : productIds) {
//            Product product = productRepository.findById(productId).orElse(null);
//            if (product == null) {
//                throw new IllegalArgumentException("없는 상품을 주문할 수 없음");
//            }
//        }
//
//        orderRepository.save(order);
//        return ResponseEntity.ok("주문완료. 주문아이디: " + order.getId());
//    }
    public ResponseEntity<String> saveOrder(SaveOrderDto dto) {

        return ResponseEntity.ok("저장완료");
    }

    public ResponseEntity<OrderDetailResponseDto> findOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("해당 주문이 존재하지 않습니다."));
        OrderDetailResponseDto orderResponse = new OrderDetailResponseDto(order.getId(), order.getProducts());
        return ResponseEntity.ok(orderResponse);
    }

    public ResponseEntity<List<OrderDetailResponseDto>> findAllOrder() {
        List<Order> oder = orderRepository.findAll();
        return ResponseEntity.ok(oder.stream().map(order -> new OrderDetailResponseDto(
                order.getId(),
                order.getProducts()
        )).toList());
    }


}
