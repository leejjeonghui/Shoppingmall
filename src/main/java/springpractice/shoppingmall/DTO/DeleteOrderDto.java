package springpractice.shoppingmall.DTO;

public record DeleteOrderDto(
        Long oderId,
        Long userId
) {
}
