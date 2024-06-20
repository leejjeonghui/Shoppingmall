package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springpractice.shoppingmall.Entity.DeliveryChargeType;
import springpractice.shoppingmall.Entity.ProductOption;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductsaveRequestDto {
    @NotEmpty
    private String name;
    @PositiveOrZero
    private Long price;
    @NotEmpty
    private String seller;
    @NotBlank
    private String brand;

    private DeliveryChargeType deliveryChargeType;

    private List<ProductOption> options = new ArrayList<>();

}
