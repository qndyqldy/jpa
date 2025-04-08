package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@DiscriminatorValue("M")
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie extends Item {
    String director;
    String actor;
}
