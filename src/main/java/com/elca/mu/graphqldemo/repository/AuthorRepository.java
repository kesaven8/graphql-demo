package com.elca.mu.graphqldemo.repository;

import com.elca.mu.graphqldemo.data.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
