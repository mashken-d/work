package com.practice.work.models;

import javax.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column
    private Integer id_rec;

    @Column
    private String date_out;

    @Column
    private String date_in;


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Books book;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "reader_id")
    private Readers reader;

    public Issue() {
    }

    public Issue( Integer id_rec, Books books, Readers reader, String date_out, String date_in) {

        this.id_rec = id_rec;
        this.book = books;
        this.reader = reader;
        this.date_out = date_out;
        this.date_in = date_in;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getId_rec() {
        return id_rec;
    }

    public void setId_rec(Integer id_rec) {
        this.id_rec = id_rec;
    }

    public String getDate_out() {
        return date_out;
    }

    public void setDate_out(String date_out) {
        this.date_out = date_out;
    }

    public String getDate_in() {
        return date_in;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }

    public Books getBook() {
        return this.book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Readers getReader () {
        return this.reader;
    }

    public void setReader (Readers reader) {
        this.reader = reader;
    }
}
