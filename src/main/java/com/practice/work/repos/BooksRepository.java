package com.practice.work.repos;

import com.practice.work.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {
    List<Books> findByname (String name);
}
