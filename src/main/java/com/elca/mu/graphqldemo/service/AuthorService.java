package com.elca.mu.graphqldemo.service;

import com.elca.mu.graphqldemo.data.Author;
import com.elca.mu.graphqldemo.repository.AuthorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public void saveAuthors(List<Author> authors) {
        authorRepository.saveAll(authors);
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @PostConstruct
    void init() {
        Author authorOne = Author.builder()
                .name("Author name One ")
                .surname("Author Surname One ")
                .age("one").build();

        Author authorTwo = Author.builder()
                .name("Author name two ")
                .surname("Author Surname two ")
                .age("two ").build();

        Author authorThree = Author.builder()
                .name("Author name three ")
                .surname("Author Surname three ")
                .age("three").build();
        authorRepository.saveAll(List.of(authorOne, authorTwo, authorThree));
    }
}
