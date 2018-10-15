package com.esakki.ticketreserve.repository;

import com.esakki.ticketreserve.model.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
