package com.elca.mu.graphqldemo.repository;

import com.elca.mu.graphqldemo.data.Author;
import com.elca.mu.graphqldemo.data.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


}
