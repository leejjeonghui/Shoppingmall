package springpractice.shoppingmall.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


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

    @Enumerated(EnumType.STRING)
    private DeliveryChargeType deliveryChargeType;

    private String  brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductOption> options = new ArrayList<>();

    @Setter
    @ManyToOne
    private User user;

    public Product(String name, Long price,String seller,String brand,DeliveryChargeType deliveryChargeType) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.brand = brand;
        this.deliveryChargeType = deliveryChargeType;
    }

    public Long getId() {
        return productId;
    }

    public void update(String name, Long price,String seller,String brand,DeliveryChargeType deliveryChargeType){
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.brand = brand;
        this.deliveryChargeType = deliveryChargeType;
    }
    public void deleteOrder() {
        this.deleted_at = OffsetDateTime.now();
    }

    public void addOption(ProductOption option) {
       options.add(option);
       option.setProduct(this);
    }


}
