package jpabook.jpashop.repository.order.query;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.OrderStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderQueryDto {
    Long orderId;
    String name;
    LocalDateTime orderDate;
    OrderStatus orderStatus;
    Address address;
    List<OrderItemQueryDto> orderItems;

    // 생성자에서 List<OrderItemQueryDto> orderItems 빼는 이유
    // jpa에서 collection을 바로 넣을 수 없어서
    public OrderQueryDto(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address) {
        this.orderId = orderId;
        this.name = name;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address;
    }
}
