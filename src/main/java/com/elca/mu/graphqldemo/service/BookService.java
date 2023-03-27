package com.elca.mu.graphqldemo.service;

import com.elca.mu.graphqldemo.data.Book;
import com.elca.mu.graphqldemo.repository.BookRepository;
import graphql.com.google.common.collect.Iterables;
import graphql.com.google.common.collect.Iterators;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.StreamSupport;


@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final AuthorService authorService;

    private final BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false).toList();
    }

    @PostConstruct
    void init() {
        authorService.findAllAuthors().forEach(author -> {
            var book = Book.builder().author(author)
                    .name("Book " + UUID.randomUUID()).rating(Book.Rating.getRating()).build();
            bookRepository.save(book);
        });
    }


}
