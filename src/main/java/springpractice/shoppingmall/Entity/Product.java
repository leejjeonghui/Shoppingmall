package springpractice.shoppingmall.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import org.hibernate.annotations.SQLDelete;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE product SET deleted_at = current_timestamp WHERE PRODUCT_ID  = ?")

public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long productId;

    @Getter
    private String name;

    @Getter
    @Min(value = 0)
    private Long price;

    @Getter
    private String seller;

    private OffsetDateTime deleted_at;

    public Product() {
    }

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

//테이블을 만드는 용도로만 사용한다

}
