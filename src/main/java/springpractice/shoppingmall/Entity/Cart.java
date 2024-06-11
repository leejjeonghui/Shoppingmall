package springpractice.shoppingmall.Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Long> productIds = new ArrayList<>();


    private Long quantity;

    public Cart(){

    }

    public Cart(List<Long> productIds,Long quantity) {
        this.productIds = productIds;
    }

    public void updatequantity(Long quantity){
        this.quantity=quantity;
    }
}
