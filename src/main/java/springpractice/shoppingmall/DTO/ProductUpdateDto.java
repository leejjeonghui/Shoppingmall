package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;

@Getter
public class ProductUpdateDto {
    private String name;
    @PositiveOrZero
    private Long price;
    private String seller;
}
