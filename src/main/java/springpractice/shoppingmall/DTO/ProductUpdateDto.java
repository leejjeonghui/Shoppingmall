package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import springpractice.shoppingmall.Entity.DeliveryChargeType;

import java.time.LocalDateTime;

@Getter
public class ProductUpdateDto {
    private String name;
    @PositiveOrZero
    private Long price;
    @NotNull
    @NotBlank
    private String seller;
    @NotNull
    private String brand;
    private DeliveryChargeType deliveryChargeType;

}
