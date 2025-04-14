package jpabook.jpashop.controller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookForm {
    Long id;
    String name;
    int price;
    int stockQuantity;

    String author;
    String isbn;
}
