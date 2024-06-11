package springpractice.shoppingmall.Entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class OrderProduct {
    private Long productId;
    private Long price; // 상품 가격에서 할인된 가격으로 주문했을 수도 있음
    private int quantity;

    public OrderProduct() {
    }
}