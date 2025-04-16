package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApiController {
    private final OrderRepository orderRepository;

    /**
     *
     * V1. 엔티티 직접 노출
     * - 엔티티가 변하면 API 스펙이 변한다.
     * - 트랜잭션 안에서 지연 로딩 필요
     * - 양방향 연관관계 문제
     * @return
     */
    @GetMapping("/api/v1/orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAll(new OrderSearch());

        // 강제 초기화
        for (Order order : all) {
            order.getMember().getName();
            order.getDelivery().getAddress();

            List<OrderItem> orderItems = order.getOrderItems();
            orderItems.stream().forEach(orderItem -> orderItem.getItem().getName());
        }

        return all;
    }

    @GetMapping("/api/v2/orders")
    public List<OrderDto> ordersV2() {
        List<Order> orders = orderRepository.findAll(new OrderSearch());

        List<OrderDto> result = orders.stream()
                .map(OrderDto::new)
                .toList();

        return result;
    }

    @GetMapping("/api/v3/orders")
    public List<OrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithItem();

        List<OrderDto> result = orders.stream()
                .map(OrderDto::new)
                .toList();

        return result;
    }

    // DTO 안에 Entity가 있으면 안됨!
    // OrderItem 도 DTO로 변경해줘야 함
    // value object는 노출해도 괜찮다
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE)
    static class OrderDto {
        Long orderId;
        String name;
        LocalDateTime orderDate;
        OrderStatus orderStatus;
        Address address;
        List<OrderItemDto> orderItems;

        public OrderDto(Order order) {
            orderId = order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress();

            orderItems = order.getOrderItems().stream()
                    .map(orderItem -> new OrderItemDto(orderItem))
                    .toList();
        }
    }

    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE)
    static class OrderItemDto {
        String itemName;
        int orderPrice;
        int count;

        public OrderItemDto(OrderItem orderItem) {
            itemName = orderItem.getItem().getName();
            orderPrice = orderItem.getOrderPrice();
            count = orderItem.getCount();
        }
    }


}
