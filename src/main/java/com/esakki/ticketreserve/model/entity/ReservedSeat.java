package com.esakki.ticketreserve.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reserved_seat")
public class ReservedSeat {

    @Id
    @GeneratedValue
    private Long Id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservationId")
    private Reservation reservation;

    @OneToOne
    @JoinColumn(name = "theaterId")
    private Theater theater;

    @OneToOne
    @JoinColumn(name = "seatId")
    private Seat seat;


    public ReservedSeat() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
