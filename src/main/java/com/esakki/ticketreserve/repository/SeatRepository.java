package com.esakki.ticketreserve.repository;

import com.esakki.ticketreserve.model.entity.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Long> {
}
