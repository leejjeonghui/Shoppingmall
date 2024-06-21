package springpractice.shoppingmall;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springpractice.shoppingmall.Entity.Order;
import springpractice.shoppingmall.Repository.OrderRepository;

@DataJpaTest
public class OrderTest {
    @Autowired
    OrderRepository orderRepository;

}
