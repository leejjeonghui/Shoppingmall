package springpractice.shoppingmall.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springpractice.shoppingmall.Entity.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct,Long> {
}
