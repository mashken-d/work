package com.practice.work.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "books")
public class Books {

    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column
    private String year;

    @Column
    private String publisher;

    @Column
    private String city_pub;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
//    private Set<Issue> issues = new HashSet<Issue>();


    public Books() {
    }

    public Books( String name, String author, String year, String publisher, String city_pud) {

        this.name = name;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.city_pub = city_pud;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Integer getId_book() {
//        return id_book;
//    }
//
//    public void setId_book(Integer id_book) {
//        this.id_book = id_book;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCity_pub() {
        return city_pub;
    }

    public void setCity_pub(String city_pub) {
        this.city_pub = city_pub;
    }

//    public Set<Issue> getIssues () {
//        return this.issues;
//    }
//
//    public void setIssues (Set<Issue> issues) {
//        this.issues = issues;
//    }

    @Override
    public String toString(){
        return "Books [ID=Name:"+name+", Year:"+year+", Publisher:"+publisher+", City:"+city_pub+"]";
    }
}
