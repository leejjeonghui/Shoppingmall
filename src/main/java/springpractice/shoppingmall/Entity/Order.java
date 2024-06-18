package springpractice.shoppingmall.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<OrderProduct> productList = new ArrayList<>();

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> products = new ArrayList<>();

    private OffsetDateTime deleted_at;

    public void deleteOrder() {
        this.deleted_at = OffsetDateTime.now();
    }
    public Order(List<OrderProduct> productList) {
        this.productList = productList;
    }
}
