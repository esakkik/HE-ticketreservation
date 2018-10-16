package com.esakki.ticketreserve.repository;

import com.esakki.ticketreserve.model.entity.Seat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Long> {
    @Query(value = "SELECT * FROM seats s WHERE s.theater_id = ?1", nativeQuery = true)
    Iterable<Seat> findAllByTheaterTest(Long theaterId);
}
