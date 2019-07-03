package com.practice.work.service;

import com.practice.work.models.Readers;
import com.practice.work.repos.ReadersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReadersService {
    private final ReadersRepository readersrepos;

    //а нужен ли конструктор?

    public List<Readers> findAll(){
        return readersrepos.findAll();
    }

    public Optional<Readers> findById(Long id){
        return readersrepos.findById(id);
    }

    public Readers save (Readers s){
        return readersrepos.save(s);
    }

    public void deleteById(Long id){
        readersrepos.deleteById(id);
    }
}
