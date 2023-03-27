package com.elca.mu.graphqldemo.controller;

import com.elca.mu.graphqldemo.data.Author;
import com.elca.mu.graphqldemo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @Secured("ROLE_USER")
    @SchemaMapping(typeName = "Query", value = "allAuthors")
    public Iterable<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }
    @Secured("ROLE_ADMIN")
    @MutationMapping(name = "createAuthor")
    public Author createAuthor(@Argument String name, @Argument String surname, @Argument String age) {
        return authorService.createAuthor(Author.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .build());
    }
}
