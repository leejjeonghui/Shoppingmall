package springpractice.shoppingmall.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springpractice.shoppingmall.Entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {


}
