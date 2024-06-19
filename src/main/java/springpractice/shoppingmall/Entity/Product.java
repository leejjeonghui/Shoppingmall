package springpractice.shoppingmall.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.OffsetDateTime;


@Getter
@NoArgsConstructor
@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long productId;

    private String name;

    private Long price;

    private String seller;

    private OffsetDateTime deleted_at;

    public Product(String name, Long price,String seller) {
        this.name = name;
        this.price = price;
        this.seller = seller;
    }

    public Long getId() {
        return productId;
    }

    public void update(String name, Long price,String seller){
        this.name = name;
        this.price = price;
        this.seller = seller;
    }
    public void deleteOrder() {
        this.deleted_at = OffsetDateTime.now();
    }


}
