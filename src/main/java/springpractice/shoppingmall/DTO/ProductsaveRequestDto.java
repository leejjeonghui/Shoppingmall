package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
public class ProductsaveRequestDto {
    private String name;
    @Min(value = 0 )
    private Long price;
    private int quantity;
}
