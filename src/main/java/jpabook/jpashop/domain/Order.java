package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    Delivery delivery;

    LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    OrderStatus status; // 주문 상태 (ORDER, CANCEL)

    // 연관관계 메서드
     public void setMember(Member member) {
         this.member = member;

         member.getOrders().add(this);
     }

     public void addOrderItem(OrderItem orderItem) {
         orderItems.add(orderItem);
         orderItem.setOrder(this);
     }

     public void setDelivery(Delivery delivery) {
         this.delivery = delivery;
         delivery.setOrder(this);
     }



}
