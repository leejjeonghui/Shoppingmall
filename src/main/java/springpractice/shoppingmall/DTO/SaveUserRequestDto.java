package springpractice.shoppingmall.DTO;
import springpractice.shoppingmall.Entity.Order;
import springpractice.shoppingmall.Entity.Product;
import java.util.List;

public record SaveUserRequestDto(String name,
                                 String zipCode,
                                 String address,
                                 String detailAddress
) {
}
