package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class ProductsaveRequestDto {
    private String name;
    @Min(value = 0,message = "양수만 가능")
    private Long price;
    @Min(value = 0,message = "양수만 가능")
    private Long quantity;
}
