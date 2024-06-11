package springpractice.shoppingmall.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springpractice.shoppingmall.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
