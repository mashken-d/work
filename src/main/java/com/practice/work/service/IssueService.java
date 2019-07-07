package com.practice.work.service;

import com.practice.work.models.Issue;
import com.practice.work.repos.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final IssueRepository issuerepos;

    //а нужен ли конструктор?

    public List<Issue> findAll(){
        return issuerepos.findAll();
    }

    public Optional<Issue> findById(Long id){
        return issuerepos.findById(id);
    }

    public Issue save (Issue s){
        return issuerepos.save(s);
    }

    public void deleteById(Long id){
        issuerepos.deleteById(id);
    }

    public List<Issue> getAllByReaderId (Long id) { return issuerepos.getAllByReaderId(id);}

    public List<Issue> getAllByBookId (Long id) { return issuerepos.getAllByBookId(id);}
}
