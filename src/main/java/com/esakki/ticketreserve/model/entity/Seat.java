package com.esakki.ticketreserve.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="seats")
public class Seat {
    @Id
    @GeneratedValue
    @Column( name = "Id")
    private Long Id;
    @Column( name = "seatRow")
    private String seatRow;
    @Column( name = "seatNo")
    private int seatNo;
    @Column( name = "isAisle")
    private boolean isAisle;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theaterId")
    @JsonIgnore
    private Theater theater;

    @Column( name = "theaterId", insertable = false, updatable = false)
    private Long theaterId;

//    @OneToMany(mappedBy = "seats", fetch = FetchType.LAZY)
//    private Reservation reservation;

    @CreatedDate
    @Column( name = "createdAt")
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column( name = "updatedAt")
    private LocalDateTime updatedAt;
    public Seat() {
    }

    public Seat(String seatRow, int seatNo, boolean isAisle) {
        this.seatRow = seatRow;
        this.seatNo = seatNo;
        this.isAisle = isAisle;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }
}
