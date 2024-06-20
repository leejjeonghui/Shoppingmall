package springpractice.shoppingmall.DTO;
import lombok.Getter;
import org.hibernate.mapping.Array;

import java.time.LocalDate;
import java.util.ArrayList;
import springpractice.shoppingmall.Entity.DeliveryChargeType;
import springpractice.shoppingmall.Entity.ProductOption;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ProductResponseDto {

    private String name;
    private Long price;
    private String seller;
    private String brand;
    private DeliveryChargeType deliveryChargeType;
    private List<ProductOptionsDto> options;
    private LocalDate deliveryETA;
    private LocalDate createdAt;

    public ProductResponseDto(String name, Long price, String seller, String brand, DeliveryChargeType deliveryChargeType, List<ProductOptionsDto> options, LocalDate deliveryETA, LocalDate createdAt) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.brand = brand;
        this.deliveryChargeType = deliveryChargeType;
        this.options = options;
        this.deliveryETA = deliveryETA;
        this.createdAt = createdAt;
    }
}
