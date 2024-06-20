package springpractice.shoppingmall.DTO;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springpractice.shoppingmall.Entity.DeliveryChargeType;
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

    @Valid
    private List<ProductOptionsDto> options = new ArrayList<>();

    public ProductsaveRequestDto(String name, Long price, String seller, String brand, DeliveryChargeType deliveryChargeType, List<ProductOptionsDto> options) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.brand = brand;
        this.deliveryChargeType = deliveryChargeType;
        this.options = options;
    }



}
