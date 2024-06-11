package springpractice.shoppingmall.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UpdateCartRequestDto {
    private Long quantity;

    public UpdateCartRequestDto(Long quantity) {
        this.quantity = quantity;
    }
}
