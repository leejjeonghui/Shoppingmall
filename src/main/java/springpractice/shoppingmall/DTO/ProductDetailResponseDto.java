package springpractice.shoppingmall.DTO;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ProductDetailResponseDto {
    private String name;
    private Long price;
    private String seller;
    private Long productId;
    private LocalDate deliveryETA = LocalDate.now().plusDays(2);

    public ProductDetailResponseDto(String name, Long price,String seller, Long productId) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.productId = productId;
    }
}
