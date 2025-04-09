package jpabook.jpashop.repository;

import jpabook.jpashop.domain.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderSearch {

    String memberName; // 회원 이름
    OrderStatus orderStatus; // 주문 상태
}
