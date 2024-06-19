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
    private Long price; // 상품 가격에서 할인된 가격으로 주문했을 수도 있음
    private Long quantity;

    @Setter
    @ManyToOne
    private Order order;

    public OrderProduct(Long productId, Long price, Long quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
}