package springpractice.shoppingmall.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long productId;

    @Getter
    private String name;

    @Getter
    @Min(value = 0)
    private Long price;

    @Getter
    @Min(value = 0)
    private Long quantity;


    public Product() {
    }

    public Product(String name, Long price,Long quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return productId;
    }

    public void update(String name, Long price,Long quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

//테이블을 만드는 용도로만 사용한다

}
