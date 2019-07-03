package com.practice.work.models;

import javax.persistence.*;
import java.time.Year;

@Entity
@Table(name= "books")
public class Books {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer id_book;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private Year year;

    @Column
    private String publisher;

    @Column
    private String city_pub;

    public Books() {
    }

    public Books(Long id, Integer id_book, String name, String author, Year year, String publisher, String city_pud) {
        this.id = id;
        this.id_book = id_book;
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

    public Integer getId_book() {
        return id_book;
    }

    public void setId_book(Integer id_book) {
        this.id_book = id_book;
    }

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

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
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

    @Override
    public String toString(){
        return "Books [ID="+id_book+", Name:"+name+", Year:"+year+", Publisher:"+publisher+", City:"+id_book+"]";
    }
}
