package com.esakki.ticketreserve.service;

import com.esakki.ticketreserve.model.entity.Theater;
import com.esakki.ticketreserve.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TheaterSearviceImpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;
    @Override
    public Optional<Theater> getTheaterById(Long id) {
        return theaterRepository.findById(id);
    }

    @Override
    public Theater createTheater(String name) {
        return theaterRepository.save(new Theater(name));
    }
}
