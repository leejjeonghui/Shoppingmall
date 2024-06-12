package springpractice.shoppingmall.DTO;

import lombok.Getter;
import springpractice.shoppingmall.Entity.OrderProduct;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderDetailResponseDto {
    private Long oderId;
    private List<OrderProduct> products;
    private LocalDateTime overedAt = LocalDateTime.now();

    public OrderDetailResponseDto(Long oderId , List<OrderProduct> products) {
        this.oderId = oderId;
        this.products = products;
    }

}
