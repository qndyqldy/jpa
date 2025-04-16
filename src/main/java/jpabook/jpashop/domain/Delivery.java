package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Delivery {
    @Id @GeneratedValue @Column(name = "delivery_id")
    Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    Order order;

    @Embedded
    Address address;

    @Enumerated(EnumType.STRING) // ORDINAL 절대 사용 X, STRING 사용
    DeliveryStatus status; // READY, COMP
}
