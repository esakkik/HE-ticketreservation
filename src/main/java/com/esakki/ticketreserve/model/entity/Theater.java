package com.esakki.ticketreserve.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "theater")
public class Theater {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;

    public Theater() {
    }

    public Theater(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
