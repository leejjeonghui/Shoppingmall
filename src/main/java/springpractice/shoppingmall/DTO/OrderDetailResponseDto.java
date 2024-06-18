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
    private Long totalPrice;

    public OrderDetailResponseDto(Long oderId , List<OrderProductDto> products,Long totalPrice) {
        this.oderId = oderId;
        this.products = products;
        this.totalPrice = totalPrice;
    }

}
