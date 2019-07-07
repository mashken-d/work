package com.practice.work.service;

import com.practice.work.models.Books;
import com.practice.work.repos.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {
    private final BooksRepository bookrepos;

    //а нужен ли конструктор?

    public List<Books> findAll(){
        return bookrepos.findAll();
    }

    public Optional<Books> findById(Long id){ return bookrepos.findById(id); }

    public List<Books> findByname(String name) { return bookrepos.findByname(name); }

    public Books save (Books s){ return bookrepos.save(s); }

    public void deleteById(Long id){
        bookrepos.deleteById(id);
    }
}
