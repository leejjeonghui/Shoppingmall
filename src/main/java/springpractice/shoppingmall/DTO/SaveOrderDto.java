package springpractice.shoppingmall.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import springpractice.shoppingmall.Entity.OrderProduct;

import java.util.List;
@NoArgsConstructor
@Getter
public class SaveOrderDto{
    private List<OrderProductDto> products;
    private Long userId;

    public SaveOrderDto(List<OrderProductDto> products,Long userId) {
        this.products = products;
        this.userId = userId;

    }
}