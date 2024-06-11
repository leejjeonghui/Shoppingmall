package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
public class ProductUpdateDto {
    private String name;
    @Min(value = 0 )
    private Long price;

    private int quantity;
}
