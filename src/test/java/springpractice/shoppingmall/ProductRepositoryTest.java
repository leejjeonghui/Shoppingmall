package springpractice.shoppingmall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springpractice.shoppingmall.Entity.Product;
import springpractice.shoppingmall.Repository.ProductRepository;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

//    @Test
//    void saveTest() {
//        Product product = new Product("레몬주스",6000L, "쥬씨");
//        Product 저장된product = productRepository.save(product);
//        System.out.println("저장된 상품 id :" + 저장된product.getId());
//    }
}