package com.practice.work.service;

import com.practice.work.models.Books;
import com.practice.work.repos.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {
    private final BooksRepository bookrepos;

    //а нужен ли конструктор?

    @CrossOrigin(origins = "http://localhost:4200")
    public List<Books> findAll(){
        return bookrepos.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Books> findById(Long id){ return bookrepos.findById(id); }

    @CrossOrigin(origins = "http://localhost:4200")
    public List<Books> findByname(String name) { return bookrepos.findByname(name); }

    @CrossOrigin(origins = "http://localhost:4200")
    public Books save (Books s){ return bookrepos.save(s); }

    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteById(Long id){
        bookrepos.deleteById(id);
    }
}
