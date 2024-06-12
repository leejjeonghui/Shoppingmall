package springpractice.shoppingmall.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springpractice.shoppingmall.Entity.OrderProduct;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SaveOrderDto {
 List<SaveProductOrderDto> products = new ArrayList<>();
}
