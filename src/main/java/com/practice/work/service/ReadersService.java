package com.practice.work.service;

import com.practice.work.models.Readers;
import com.practice.work.repos.ReadersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReadersService {
    private final ReadersRepository readersrepos;

    //а нужен ли конструктор?

    @CrossOrigin(origins = "http://localhost:4200")
    public List<Readers> findAll(){
        return readersrepos.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Readers> findById(Long id){
        return readersrepos.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public List<Readers> findByfl_name(String fl_name) { return readersrepos.findByfl_name(fl_name);}

    @CrossOrigin(origins = "http://localhost:4200")
    public Readers save (Readers s){
        return readersrepos.save(s);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteById(Long id){
        readersrepos.deleteById(id);
    }
}
