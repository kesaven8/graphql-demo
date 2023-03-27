package com.elca.mu.graphqldemo.repository;

import com.elca.mu.graphqldemo.data.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
