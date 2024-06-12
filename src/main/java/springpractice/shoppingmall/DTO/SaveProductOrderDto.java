package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springpractice.shoppingmall.Entity.OrderProduct;

@NoArgsConstructor
@Getter
public class SaveProductOrderDto {
    private Long productId;
    private Long price;
    private Long quantity;

    public SaveProductOrderDto(Long productId, Long price, Long quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
}

