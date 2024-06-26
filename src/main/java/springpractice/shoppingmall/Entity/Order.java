package springpractice.shoppingmall.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderProduct> products = new ArrayList<>();

    @OneToOne
    private Delivery delivery;

    private OffsetDateTime deleted_at;

    @Setter
    @ManyToOne
    private User user;

    public void deleteOrder() {
        this.deleted_at = OffsetDateTime.now();
    }
    public Order(List<OrderProduct> products) {
        this.products = products;
    }

    public void addOrderProduct(OrderProduct orderProduct){
        products.add(orderProduct);
        orderProduct.setOrder(this);
    }
}
