package com.elca.mu.graphqldemo.controller;

import com.elca.mu.graphqldemo.data.Book;
import com.elca.mu.graphqldemo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @SchemaMapping(typeName = "Query", value = "allBooks")
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

}
