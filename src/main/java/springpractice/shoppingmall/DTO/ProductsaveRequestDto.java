package springpractice.shoppingmall.DTO;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import springpractice.shoppingmall.Entity.DeliveryChargeType;
import java.util.ArrayList;
import java.util.List;


@Getter
public class ProductsaveRequestDto {
    @NotEmpty
    private String name;
    @PositiveOrZero
    private Long price;
    @NotBlank
    private String brand;
    @NotNull
    private Long userId;

    private DeliveryChargeType deliveryChargeType;

    @Valid
    private List<ProductOptionsDto> options = new ArrayList<>();

    public ProductsaveRequestDto(String name, Long price, String brand,
                                 DeliveryChargeType deliveryChargeType,
                                 List<ProductOptionsDto> options,Long userId) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.deliveryChargeType = deliveryChargeType;
        this.options = options;
        this.userId = userId;
    }



}
