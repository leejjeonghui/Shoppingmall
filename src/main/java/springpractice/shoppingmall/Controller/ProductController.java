package springpractice.shoppingmall.Controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springpractice.shoppingmall.DTO.*;
import springpractice.shoppingmall.Entity.Product;
import springpractice.shoppingmall.Repository.ProductRepository;
import springpractice.shoppingmall.Service.ProductService;

import java.rmi.NoSuchObjectException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //상품등록, 상품조회(all), 상품조회(상세조회 id), 상품수정, 삭제
    ProductRepository repository;
    ProductService service;

    public ProductController(ProductRepository repository,ProductService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("/")
    ResponseEntity<String> saveProduct(@Valid @RequestBody ProductsaveRequestDto request) throws NoSuchObjectException {
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
    ResponseEntity<String> deleteProduct(@RequestBody ProductDeleteDto dto) throws NoSuchObjectException {
    return service.deleteProduct(dto);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDto dto){
        return service.updateProductById(id,dto);
    }
//컨트롤러에서는 외부데이터만 검사

}
