package springpractice.shoppingmall.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zipCode;

    private String address;

    private String detailAddress;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @OneToOne
    @JoinColumn (name = "orders")
    private Order order;

    private LocalDateTime createdDateTime = LocalDateTime.now(); // 기본 값 세팅

    private LocalDateTime modifiedDateTime = LocalDateTime.now(); // 기본 값 세팅

    protected Delivery() { // public이어도 되지만, 다른 개발자가 기본 생성자를 사용할 수 없게 막음
    }

    public Delivery(String zipCode, String address, String detailAddress) {
        this.zipCode = zipCode;
        this.address = address;
        this.detailAddress = detailAddress;
        this.deliveryStatus = DeliveryStatus.배송준비;
    }
}