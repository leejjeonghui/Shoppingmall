package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springpractice.shoppingmall.Entity.Product;

@Getter
public class ProductResponseDto {
    private String name;
    private Long price;
    private Long productId;

    public ProductResponseDto(String name, Long price,Long productId) {
        this.name = name;
        this.price = price;
        this.productId = productId;
    }

}
