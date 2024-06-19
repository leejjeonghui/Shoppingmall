package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class ProductsaveRequestDto {
    private String name;
    @PositiveOrZero
    private Long price;

    private String seller;
}
