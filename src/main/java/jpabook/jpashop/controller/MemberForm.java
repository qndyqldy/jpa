package jpabook.jpashop.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberForm {
    @NotEmpty(message = "회원 이름은 필수 입니다.")
    String name;

    String city;
    String street;
    String zipcode;
}
