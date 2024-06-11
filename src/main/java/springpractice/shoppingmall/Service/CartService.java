package springpractice.shoppingmall.Service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import springpractice.shoppingmall.DTO.SaveCartRequestDto;
import springpractice.shoppingmall.Entity.Product;
import springpractice.shoppingmall.Repository.CartRepository;
import springpractice.shoppingmall.Repository.ProductRepository;

@Service
public class CartService {
    CartRepository cartRepository;
    ProductRepository productRepository;

    public CartService(CartRepository cartRepository,ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }


}
