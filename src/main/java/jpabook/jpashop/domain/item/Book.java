package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@DiscriminatorValue("B")
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book extends Item {
    String author;
    String isbn;
}
