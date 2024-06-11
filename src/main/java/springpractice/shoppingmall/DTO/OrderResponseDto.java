package springpractice.shoppingmall.DTO;

import lombok.Getter;
import springpractice.shoppingmall.Entity.OrderProduct;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderResponseDto {
    private Long oderId;
    private Long price;
    private Long totalPrice;
    private List<OrderProduct> products;
    private LocalDateTime overedAt = LocalDateTime.now();

    public OrderResponseDto(Long oderId ,Long price, List<OrderProduct> products) {
        this.oderId = oderId;
        this.price = price;
        this.products = products;
    }

}
