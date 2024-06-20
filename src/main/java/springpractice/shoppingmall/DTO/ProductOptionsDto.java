package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductOptionsDto {
    @NotNull
    private String optionType;
    @NotNull
    private String optionValue;
    @Max(value = 999)
    private int maximumBuyCount;
    public ProductOptionsDto(String optionType, String optionValue, int maximumBuyCount) {
        this.optionType = optionType;
        this.optionValue = optionValue;
        this.maximumBuyCount = maximumBuyCount;
    }

}
