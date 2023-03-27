package com.elca.mu.graphqldemo;

import com.elca.mu.graphqldemo.controller.AuthorController;
import com.elca.mu.graphqldemo.data.Author;
import com.elca.mu.graphqldemo.repository.AuthorRepository;
import com.elca.mu.graphqldemo.service.AuthorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Import({AuthorService.class, AuthorRepository.class})
@GraphQlTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Autowired
    private AuthorService authorService;

    @MockBean
    private AuthorRepository authorRepository;

    @BeforeEach
    public void init() {
        authorService = new AuthorService(authorRepository);
    }

    @Test
    void testFindAllAuthorsShouldReturnAllAuthors() {

        Mockito.when(authorService.findAllAuthors()).thenReturn(List.of(Author.builder().id(1L)
                .name("Author 001")
                .surname("Author 001 surname")
                .age("55")
                .build()));
        // language=GraphQL
        String query = """
                query {
                    allAuthors {
                        id
                        name
                        surname
                    }
                }
                """;

        graphQlTester.document(query)
                .execute()
                .path("allAuthors")
                .entityList(Author.class)
                .satisfies(authors -> {
                    assertEquals(authors.size(),1);
                    assertEquals(authors.get(0).getName(),"Author 001");
                    assertNull(authors.get(0).getAge()); // why ??
                });

    }


}
