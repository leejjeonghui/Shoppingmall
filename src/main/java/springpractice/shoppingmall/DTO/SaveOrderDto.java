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
    private List<OrderProduct> products;

    public SaveOrderDto(List<OrderProduct> products) {
        this.products = products;
    }

}