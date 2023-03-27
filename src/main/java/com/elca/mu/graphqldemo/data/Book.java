package com.elca.mu.graphqldemo.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Random;
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Rating rating;

    @ManyToOne
    private Author author;

    public enum Rating {
        FIVE, FOUR, THREE, TWO, ONE;

        public static Rating getRating() {
            var random = new Random().ints(5, 0, 5).findAny();
            return Rating.values()[random.isEmpty() ? 0 : random.getAsInt()];
        }
    }

}
