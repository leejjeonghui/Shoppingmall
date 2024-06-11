package springpractice.shoppingmall.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springpractice.shoppingmall.Entity.OrderProduct;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class SaveOrderDto {
 List<OrderProduct> products = new ArrayList<>();
}
