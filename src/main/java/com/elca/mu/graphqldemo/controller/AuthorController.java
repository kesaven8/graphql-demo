package com.elca.mu.graphqldemo.controller;

import com.elca.mu.graphqldemo.data.Author;
import com.elca.mu.graphqldemo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @SchemaMapping(typeName = "Query", value = "allAuthors")
    public Iterable<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }
}
