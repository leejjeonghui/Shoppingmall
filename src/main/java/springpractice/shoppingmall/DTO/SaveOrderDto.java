package springpractice.shoppingmall.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
@NoArgsConstructor
@Getter
public class SaveOrderDto{
    private List<OrderProductDto> productDtos;

    public SaveOrderDto(List<OrderProductDto> productDtos) {
        this.productDtos = productDtos;
    }

}