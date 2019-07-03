package com.practice.work.models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer Id_rec;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_book")
    private Books id_book;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_card")
    private Readers id_card;

    @Column
    private Calendar date_out;

    @Column
    private Calendar date_in;

    public Issue() {
    }

    public Issue(Long id, Integer id_rec, Books id_book, Readers id_card, Calendar date_out, Calendar date_in) {
        this.id = id;
        this.Id_rec = id_rec;
        this.id_book = id_book;
        this.id_card = id_card;
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
        return Id_rec;
    }

    public void setId_rec(Integer id_rec) {
        Id_rec = id_rec;
    }

    public Books getId_book() {
        return id_book;
    }

    public void setId_book(Books id_book) {
        this.id_book = id_book;
    }

    public Readers getId_card() {
        return id_card;
    }

    public void setId_card(Readers id_card) {
        this.id_card = id_card;
    }

    public Calendar getDate_out() {
        return date_out;
    }

    public void setDate_out(Calendar date_out) {
        this.date_out = date_out;
    }

    public Calendar getDate_in() {
        return date_in;
    }

    public void setDate_in(Calendar date_in) {
        this.date_in = date_in;
    }
}
