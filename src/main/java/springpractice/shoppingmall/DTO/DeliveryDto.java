package springpractice.shoppingmall.DTO;

public record DeliveryDto(
        String zipCode,

        String address,

        String detailAddress
) {
}
