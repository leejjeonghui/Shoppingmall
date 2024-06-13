package springpractice.shoppingmall.DTO;

import lombok.NonNull;

import java.util.List;

public record SaveOrderDto(List<Product> products) {
    public record Product(
            Long id,
            long price,
            int quantity
    ) {
    }
}