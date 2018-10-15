package com.esakki.ticketreserve.model.entity;

import javax.persistence.*;

@Entity
@Table(name="seats")
public class Seat {
    @Id
    @GeneratedValue
    private Long Id;
    private String row;
    private String column;
    private boolean isAisle;
    @ManyToOne
    @JoinColumn(name = "theaterId")
    private Theater theater;

    public Seat() {
    }

    public Seat(String row, String column, boolean isAisle) {
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

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public boolean isAisle() {
        return isAisle;
    }

    public void setAisle(boolean aisle) {
        isAisle = aisle;
    }
}
