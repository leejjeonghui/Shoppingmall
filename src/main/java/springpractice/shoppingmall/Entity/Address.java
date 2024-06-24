package springpractice.shoppingmall.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Address {
    private String zipCode;

    private String address;

    private String detailAddress;
}
