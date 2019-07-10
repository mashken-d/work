package com.practice.work.service;

import com.practice.work.models.Issue;
import com.practice.work.repos.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final IssueRepository issuerepos;

    //а нужен ли конструктор?

    @CrossOrigin(origins = "http://localhost:4200")
    public List<Issue> findAll(){
        return issuerepos.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Issue> findById(Long id){
        return issuerepos.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public Issue save (Issue s){
        return issuerepos.save(s);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteById(Long id){
        issuerepos.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    public List<Issue> getAllByReaderId (Long id) { return issuerepos.getAllByReaderId(id);}

    @CrossOrigin(origins = "http://localhost:4200")
    public List<Issue> getAllByBookId (Long id) { return issuerepos.getAllByBookId(id);}
}
