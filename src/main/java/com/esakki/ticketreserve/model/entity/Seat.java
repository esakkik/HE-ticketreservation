package com.esakki.ticketreserve.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="seats")
public class Seat {
    @Id
    @GeneratedValue
    private Long Id;
    private String row;
    private int column;
    private boolean isAisle;
    @ManyToOne
    @JoinColumn(name = "theaterId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Theater theater;

    public Seat() {
    }

    public Seat(String row, int column, boolean isAisle) {
        this.row = row;
        this.column = column;
        this.isAisle = isAisle;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isAisle() {
        return isAisle;
    }

    public void setAisle(boolean aisle) {
        isAisle = aisle;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
