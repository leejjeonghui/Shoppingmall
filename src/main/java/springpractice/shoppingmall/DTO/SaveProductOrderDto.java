package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class SaveProductOrderDto {
    private Long productId;
    @Min(value = 0)
    private int quantity;
    @Min(value = 0)
    private Long price;
}

