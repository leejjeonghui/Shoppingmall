package springpractice.shoppingmall.Service;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springpractice.shoppingmall.DTO.ProductResponseDto;
import springpractice.shoppingmall.DTO.ProductUpdateDto;
import springpractice.shoppingmall.DTO.ProductsaveRequestDto;
import springpractice.shoppingmall.Entity.Product;
import springpractice.shoppingmall.Repository.ProductRepository;

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
        Product product = new Product(request.getName(), request.getPrice(),request.getQuantity());
        productRepository.save(product);
        return ResponseEntity.ok("상품저장완료. id: "+product.getId());
    }


    public ResponseEntity<ProductResponseDto> findProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        ProductResponseDto productResponseDto = new ProductResponseDto(product.getName(), product.getPrice(),product.getId());
        return ResponseEntity.ok(productResponseDto);
    }


    public ResponseEntity<List<ProductResponseDto>> findAllProduct(){
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(
                products.stream().map(product ->
                        new ProductResponseDto(
                                product.getName(),
                                product.getPrice(),
                                product.getId()))
                        .toList());
    }
    public ResponseEntity<String> deleteProductById(Long id){
        productRepository.deleteById(id);
        return ResponseEntity.ok("삭제완료.");
    }

    @Transactional
    public ResponseEntity<String> updateProductById(Long id, ProductUpdateDto dto){
        Product product = productRepository.findById(id).orElse(null);
        product.update(dto.getName(),dto.getPrice(),dto.getQuantity());
        productRepository.save(product);
        return ResponseEntity.ok("수정완료. 상품 id : " + product.getId());
    }


}
