package springpractice.shoppingmall.DTO;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springpractice.shoppingmall.Entity.Product;

public class ProductResponseDto {
    private String name;
    private Long price;
    private Long productId;

    public ProductResponseDto(String name, Long price, Long productId) {
        this.name = name;
        this.price = price;
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public Long getProductId() {
        return productId;
    }

//    public ProductResponseDto(Product product){
//        this.name = product.getName();
//        this.price = product.getPrice();
//        this.productId = product.getId();
//    }
}
