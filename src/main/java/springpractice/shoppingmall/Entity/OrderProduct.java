package springpractice.shoppingmall.Entity;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class OrderProduct {
    private Long productId;
    private Long price; // 상품 가격에서 할인된 가격으로 주문했을 수도 있음
    private Long quantity;

    public OrderProduct(Long productId,Long price,Long quantity){
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
}