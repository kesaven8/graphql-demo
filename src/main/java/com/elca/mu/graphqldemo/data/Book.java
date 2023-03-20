package com.elca.mu.graphqldemo.data;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Rating rating;

    @ManyToOne
    private Author author;

    enum Rating {
        FIVE, FOUR, THREE, TWO, ONE
    }

}
