package springpractice.shoppingmall.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springpractice.shoppingmall.DTO.ProductDetailResponseDto;
import springpractice.shoppingmall.DTO.ProductResponseDto;
import springpractice.shoppingmall.DTO.ProductUpdateDto;
import springpractice.shoppingmall.DTO.ProductsaveRequestDto;
import springpractice.shoppingmall.Entity.Product;
import springpractice.shoppingmall.Repository.ProductRepository;
import springpractice.shoppingmall.Service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    //상품등록, 상품조회(all), 상품조회(상세조회 id), 상품수정, 삭제
    ProductRepository repository;
    ProductService service;

    public ProductController(ProductRepository repository,ProductService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("/")
    ResponseEntity<String> saveProduct(@RequestBody ProductsaveRequestDto request){
        return service.saveProduct(request);
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductDetailResponseDto> findProductById(@PathVariable Long id){
        return service.findProductById(id);
    }

    @GetMapping("/all")
    ResponseEntity<List<ProductResponseDto>> findProducts(){
       return service.findAllProduct();
    }

    @PatchMapping("/{id}")
    ResponseEntity<String> deleteProductById(@PathVariable Long id){
    return service.deleteProductById(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDto dto){
        return service.updateProductById(id,dto);
    }

}
