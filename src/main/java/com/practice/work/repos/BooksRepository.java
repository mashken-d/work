package com.practice.work.repos;

import com.practice.work.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface BooksRepository extends JpaRepository<Books, Long> {
    List<Books> findByname (String name);
}
