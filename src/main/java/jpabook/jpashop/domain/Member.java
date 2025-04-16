package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    Long id;

    String name;

    @Embedded // 내장 타입
    Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "member") // mapping 된 - 읽기 전용
    List<Order> orders = new ArrayList<>();
}
