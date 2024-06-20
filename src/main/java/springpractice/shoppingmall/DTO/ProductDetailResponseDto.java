package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import springpractice.shoppingmall.Entity.DeliveryChargeType;
import springpractice.shoppingmall.Entity.ProductOption;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductDetailResponseDto {
    private String name;
    private Long price;
    private String brand;
    private String seller;
    private Long productId;
    private DeliveryChargeType deliveryChargeType;
    private List<ProductOptionsDto> options = new ArrayList<>();
    private LocalDate deliveryETA = LocalDate.now().plusDays(2);
    private LocalDate createdAt;

    public ProductDetailResponseDto(String name, Long price, String brand, String seller, Long productId, DeliveryChargeType deliveryChargeType, List<ProductOptionsDto> options, LocalDate deliveryETA, LocalDate createdAt) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.seller = seller;
        this.productId = productId;
        this.deliveryChargeType = deliveryChargeType;
        this.options = options;
        this.deliveryETA = deliveryETA;
        this.createdAt = createdAt;
    }



}
