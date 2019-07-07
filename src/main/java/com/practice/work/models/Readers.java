package com.practice.work.models;

import javax.persistence.*;

@Entity
@Table(name = "readers")
public class Readers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String fl_name;

    @Column
    private String address;

    @Column
    private String phone;

    @Column(name = "id_card", nullable = false)
    private Integer id_card;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "reader")
//    private Set<Issue> issues = new HashSet<Issue>();


    public Readers() {}

    public Readers( Integer id_card, String fl_name, String address, String phone) {

        this.id_card = id_card;
        this.fl_name = fl_name;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getId_card() {
        return id_card;
    }

    public void setId_card(Integer id_card) {
        this.id_card = id_card;
    }

    public String getFl_name() {
        return fl_name;
    }

    public void setFl_name(String fl_name) {
        this.fl_name = fl_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public Set<Issue> getIssues () {
//        return this.issues;
//    }
//
//    public void setIssues (Set<Issue> issues) {
//        this.issues = issues;
//    }

}
