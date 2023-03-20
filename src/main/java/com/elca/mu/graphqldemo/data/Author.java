package com.elca.mu.graphqldemo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Author {

    @Id
    private Long id;
    private String name;
    private String surname;
    private String age;
}
