package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@DiscriminatorValue("A")
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Album extends Item {
    String artist;
    String etc;
}
