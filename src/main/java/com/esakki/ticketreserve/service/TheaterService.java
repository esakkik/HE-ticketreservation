package com.esakki.ticketreserve.service;

import com.esakki.ticketreserve.model.dto.TheaterSeatDTO;
import com.esakki.ticketreserve.model.entity.Seat;
import com.esakki.ticketreserve.model.entity.Theater;

import java.util.Optional;

public interface TheaterService {

    Optional<Theater> getTheaterById(Long id);

    Theater createTheater(TheaterSeatDTO theaterSeatDTO);

    Iterable<Seat> getSeatListByTheater(Long theaterId);
}
