package springpractice.shoppingmall.DTO;

import java.time.OffsetDateTime;
import java.util.List;

public record OrdersResponseDto(Long orderId,
                                Long totalPrice,
                                List<String> productNames,
                                OffsetDateTime orderedAt) {
}
