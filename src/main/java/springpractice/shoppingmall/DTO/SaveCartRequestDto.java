package springpractice.shoppingmall.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter

public class SaveCartRequestDto {
   private Long productId;
    public Long getProductId() {
        return productId;
    }
}
