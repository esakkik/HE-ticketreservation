package com.esakki.ticketreserve.service;

import com.esakki.ticketreserve.model.entity.Theater;

import java.util.Optional;

public interface TheaterService {

    Optional<Theater> getTheaterById(Long id);

    Theater createTheater(String name);
}
