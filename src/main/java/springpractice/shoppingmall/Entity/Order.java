package springpractice.shoppingmall.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.Where;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor
@SQLDelete(sql = "UPDATE orders SET deleted_at = current_timestamp WHERE id = ?")
//@SQLDelete 는 JPA를 통해 엔티티 삭제가 발생할 시, delete 쿼리가 아닌 입력한 sql 을 실행시킨다.

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<OrderProduct> products = new ArrayList<>();

    private OffsetDateTime deleted_at;

    public Order(List<OrderProduct> products) {
        this.products = products;
    }

}
