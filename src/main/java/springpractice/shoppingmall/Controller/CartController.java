package springpractice.shoppingmall.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springpractice.shoppingmall.DTO.SaveCartRequestDto;
import springpractice.shoppingmall.DTO.UpdateCartRequestDto;
import springpractice.shoppingmall.Entity.Cart;
import springpractice.shoppingmall.Entity.Product;
import springpractice.shoppingmall.Repository.CartRepository;
import springpractice.shoppingmall.Repository.ProductRepository;
import springpractice.shoppingmall.Service.CartService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    CartRepository cartRepository;
    ProductRepository productRepository;
    Cart cart;

    public CartController(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cart = cartRepository.save(new Cart());
    }

    @PostMapping("/")
    ResponseEntity<String> saveCart(@RequestBody SaveCartRequestDto dto){
        cart.getProductIds().add(dto.getProductId());
        return ResponseEntity.ok("등록완료");
    }

    @GetMapping("/")
    ResponseEntity <List<Product>> findCartItem(){
        ArrayList<Product> items = new ArrayList<>();
        for (Long productId : cart.getProductIds()) {
           items.add(productRepository.findById(productId).orElse(null));
        }
        return ResponseEntity.ok(items);
    }

    @PatchMapping("/{productId}")
    ResponseEntity<String> updateCart(@PathVariable Long productId,
                                      @RequestBody UpdateCartRequestDto dto){

         cart.updatequantity(dto.getQuantity());
         return ResponseEntity.ok( "변경완료.");
    }


}
