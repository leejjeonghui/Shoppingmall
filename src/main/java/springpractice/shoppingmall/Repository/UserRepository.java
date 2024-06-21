package springpractice.shoppingmall.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springpractice.shoppingmall.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
