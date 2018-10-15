package com.esakki.ticketreserve.repository;

import com.esakki.ticketreserve.model.entity.ReservedSeat;
import org.springframework.data.repository.CrudRepository;

public interface ReservedSeatRepository extends CrudRepository<ReservedSeat, Long> {
}
