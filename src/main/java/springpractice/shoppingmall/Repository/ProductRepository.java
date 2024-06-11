package springpractice.shoppingmall.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springpractice.shoppingmall.DTO.ProductResponseDto;
import springpractice.shoppingmall.Entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
