package springpractice.shoppingmall.Service;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springpractice.shoppingmall.DTO.*;
import springpractice.shoppingmall.Entity.DeliveryChargeType;
import springpractice.shoppingmall.Entity.Product;
import springpractice.shoppingmall.Entity.ProductOption;
import springpractice.shoppingmall.Repository.ProductRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private  ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<String> saveProduct(ProductsaveRequestDto request){
        Product product = new Product(request.getName(), request.getPrice(),
                request.getSeller(),request.getBrand(),
                request.getDeliveryChargeType());

        for (ProductOption productOption: request.getOptions()) {
            product.addOption(productOption);
        }
        productRepository.save(product);
        return ResponseEntity.ok("상품저장완료. id: "+product.getId());
    }


    public ResponseEntity<ProductDetailResponseDto> findProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        ProductDetailResponseDto dto = new ProductDetailResponseDto(
                product.getName(), product.getPrice(),product.getBrand(),
                product.getSeller(),product.getId(), product.getDeliveryChargeType(),
                product.getOptions().stream().map(o->
                        new ProductOptionsDto(
                        o.getOptionType(),o.getOptionValue(),o.getMaximumBuyCount()
                        )).toList(),
                LocalDate.now().plusDays(2),LocalDate.now()
                );
        return ResponseEntity.ok(dto);
    }
//    private String name;
//    private Long price;
//    private String brand;
//    private String seller;
//    private Long productId;
//    private DeliveryChargeType deliveryChargeType;
//    private List<ProductOption> options = new ArrayList<>();
//    private LocalDate deliveryETA = LocalDate.now().plusDays(2);
//    private LocalDate createdAt;


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

    public ResponseEntity<String> deleteProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당상품이 존저하지 않음"));
        product.deleteOrder();
        return ResponseEntity.ok("삭제완료.");
    }

    @Transactional
    public ResponseEntity<String> updateProductById(Long id, ProductUpdateDto dto){
        Product product = productRepository.findById(id).orElse(null);
        product.update(dto.getName(),dto.getPrice(),dto.getSeller(),dto.getBrand(),dto.getDeliveryChargeType());
        productRepository.save(product);
        return ResponseEntity.ok("수정완료. 상품 id : " + product.getId());
    }


}
