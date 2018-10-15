package com.esakki.ticketreserve.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reserved_seat")
public class ReservedSeat {

    @Id
    @GeneratedValue
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToMany
    @JoinColumn(name = "theater_id")
    private List<Theater> theater;

    @ManyToMany
    @JoinColumn(name = "seat_id")
    private List<Seat> seat;
}
