package jpabook.jpashop.controller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderForm {
    Long memberId;
    Long itemId;
    int count;
}
