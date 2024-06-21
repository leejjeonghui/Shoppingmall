package springpractice.shoppingmall.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.mapping.Array;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String zipCode;

    private String address;

    private String detailAddress;

    private LocalDateTime createdDateTime = LocalDateTime.now();


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL )
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Order> order = new ArrayList<>();

    public User(){

    }

    public User(String name, String zipCode, String address, String detailAddress) {
        this.name = name;
        this.zipCode = zipCode;
        this.address = address;
        this.detailAddress = detailAddress;
    }



}
