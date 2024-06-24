package springpractice.shoppingmall.Service;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springpractice.shoppingmall.DTO.*;
import springpractice.shoppingmall.Entity.Product;
import springpractice.shoppingmall.Entity.ProductOption;
import springpractice.shoppingmall.Entity.User;
import springpractice.shoppingmall.Repository.ProductRepository;
import springpractice.shoppingmall.Repository.UserRepository;

import java.rmi.NoSuchObjectException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private  ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> saveProduct(ProductsaveRequestDto request) throws NoSuchObjectException {
        User user = userRepository.getReferenceById(request.getUserId());
        if(!userRepository.existsById(request.getUserId())){
            throw new NoSuchObjectException("회원만 상품 등록 가능");
        }
        Product product = new Product(
                request.getName(),
                request.getPrice(),
                user.getName(),
                request.getBrand(),
                request.getDeliveryChargeType());
        for (ProductOptionsDto dto: request.getOptions()) {
            ProductOption productOption = new ProductOption(
                    dto.getOptionType(),
                    dto.getOptionValue(),
                    dto.getMaximumBuyCount());
            product.addOption(productOption);
        }
        
        product.setUser(user);
        productRepository.save(product);
        return ResponseEntity.ok("상품저장완료. id: "+product.getId());
    }


    public ResponseEntity<ProductDetailResponseDto> findProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        ProductDetailResponseDto dto = new ProductDetailResponseDto(
                product.getName(), product.getPrice(),
                product.getBrand(), product.getSeller(),
                product.getId(), product.getDeliveryChargeType(),
                product.getOptions().
                        stream().map(o->
                        new ProductOptionsDto(
                                o.getOptionType(),
                                o.getOptionValue(),
                                o.getMaximumBuyCount()
                        )).toList(),
                LocalDate.now().plusDays(2),
                LocalDate.now()
                );
        return ResponseEntity.ok(dto);
    }


    public ResponseEntity<List<ProductResponseDto>> findAllProduct(){
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(
                products.stream().map(product ->
                        new ProductResponseDto(
                                product.getName(),
                                product.getPrice(),
                                product.getSeller(),
                                product.getBrand(),
                                product.getDeliveryChargeType(),
                                product.getOptions().stream().map(o->
                                        new ProductOptionsDto(o.getOptionType(),o.getOptionValue(),o.getMaximumBuyCount())).toList(),
                                LocalDate.now().plusDays(2),
                                LocalDate.now()
                        )).toList());

    }

    @Transactional
    public ResponseEntity<String> deleteProduct(ProductDeleteDto dto) throws NoSuchObjectException {
        Product product = productRepository.findById(dto.productId())
                .orElseThrow(()-> new IllegalArgumentException("해당상품이 존저하지 않음"));
        if(!Objects.equals(product.getUser().getId(), dto.userId())){
            throw new NoSuchObjectException("다른 유저가 등록한 상품을 삭제할 수 없습니다.");
        }
        product.deleteOrder();
        return ResponseEntity.ok("삭제성공.");
    }

    @Transactional
    public ResponseEntity<String> updateProductById(Long id, ProductUpdateDto dto){
        Product product = productRepository.findById(id).orElse(null);
        product.update(dto.getName(),
                dto.getPrice(),dto.getSeller(),
                dto.getBrand(),dto.getDeliveryChargeType());
        productRepository.save(product);
        return ResponseEntity.ok("수정완료. 상품 id : " + product.getId());
    }


}
