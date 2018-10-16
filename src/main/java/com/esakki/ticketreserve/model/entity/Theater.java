package com.esakki.ticketreserve.model.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "theater")
public class Theater {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long Id;
    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "theater", fetch = FetchType.LAZY)
//    private Set<Seat> seats;
//
//    @OneToMany(mappedBy = "theater", fetch = FetchType.LAZY)
//    private Set<Reservation> reservations;
    @CreatedDate
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
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

//    public Set<Seat> getSeats() {
//        return seats;
//    }
//
//    public void setSeats(Set<Seat> seats) {
//        this.seats = seats;
//    }
//
//    public Set<Reservation> getReservations() {
//        return reservations;
//    }
//
//    public void setReservations(Set<Reservation> reservations) {
//        this.reservations = reservations;
//    }

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
}
