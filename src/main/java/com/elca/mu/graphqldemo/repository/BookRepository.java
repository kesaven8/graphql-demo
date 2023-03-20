package com.elca.mu.graphqldemo.repository;

import com.elca.mu.graphqldemo.data.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
