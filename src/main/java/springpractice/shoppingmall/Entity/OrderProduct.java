package springpractice.shoppingmall.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Long quantity;

    @Setter
    @ManyToOne
    private Order order;

    public OrderProduct(Long productId,Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}