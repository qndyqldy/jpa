package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;      
                                          
@Embeddable // 내장 타입
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {
    String city;                            
    String street;
    String zipcode;

    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
