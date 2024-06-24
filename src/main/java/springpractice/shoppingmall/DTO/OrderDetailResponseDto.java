package springpractice.shoppingmall.DTO;

import lombok.Getter;
import springpractice.shoppingmall.Entity.OrderProduct;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderDetailResponseDto {
    private Long oderId;
    private List<OrderProductDto> products;
    private LocalDateTime overedAt = LocalDateTime.now();
    /*private Long totalPrice;*/
    private Long userId;

    public OrderDetailResponseDto(Long oderId , List<OrderProductDto> products,/*,Long totalPrice,*/Long userId) {
        this.oderId = oderId;
        this.products = products;
        this.userId = userId;
    }

}
