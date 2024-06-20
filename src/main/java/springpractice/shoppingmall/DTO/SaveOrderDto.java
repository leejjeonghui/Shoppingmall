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

    public SaveOrderDto(List<OrderProductDto> products) {
        this.products = products;
    }

}