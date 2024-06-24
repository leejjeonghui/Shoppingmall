package springpractice.shoppingmall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springpractice.shoppingmall.DTO.DeleteOrderDto;
import springpractice.shoppingmall.Entity.Product;
import springpractice.shoppingmall.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    private DeleteOrderDto dto = new DeleteOrderDto(1L,1L);


}