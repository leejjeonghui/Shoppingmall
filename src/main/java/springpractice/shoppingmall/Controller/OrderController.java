package springpractice.shoppingmall.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springpractice.shoppingmall.DTO.OrderDetailResponseDto;
import springpractice.shoppingmall.DTO.SaveOrderDto;
import springpractice.shoppingmall.DTO.SaveProductOrderDto;
import springpractice.shoppingmall.Entity.OrderProduct;
import springpractice.shoppingmall.Entity.Product;
import springpractice.shoppingmall.Repository.OrderRepository;
import springpractice.shoppingmall.Repository.ProductRepository;
import springpractice.shoppingmall.Service.OrderService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    OrderRepository orderRepository;
    OrderService orderService;
    ProductRepository productRepository;

    public OrderController(OrderRepository orderRepository, OrderService orderService,ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.productRepository = productRepository;
    }

//    @RequestMapping("/")
//    public ResponseEntity<String> saveOrder(@RequestBody SaveOrderDto dto){
//        return orderService.saveOrder(dto);
//    }
    @RequestMapping("/")
    public ResponseEntity<String> saveOrder(@RequestBody  SaveOrderDto dto){
     return orderService.saveOrder(dto);
    }

    @GetMapping ("/{orderId}")
    public ResponseEntity<OrderDetailResponseDto> findOrder(@PathVariable Long orderId){
        return orderService.findOrder(orderId);
    }

//    @GetMapping ("/all")
//    public ResponseEntity <List<OrderDetailResponseDto>> findAllOrder(){
//        return orderService.findAllOrder();
//    }

}
