package com.esakki.ticketreserve.repository;

import com.esakki.ticketreserve.model.entity.Seat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatRepository extends CrudRepository<Seat, Long> {
    public List<Seat> findAllByTheater(Long theaterId);
}
