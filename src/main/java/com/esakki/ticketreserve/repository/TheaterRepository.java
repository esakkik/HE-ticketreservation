package com.esakki.ticketreserve.repository;

import com.esakki.ticketreserve.model.entity.Theater;
import org.springframework.data.repository.CrudRepository;

public interface TheaterRepository extends CrudRepository<Theater, Long> {
}
