package com.esakki.ticketreserve.service;

import com.esakki.ticketreserve.model.dto.SeatInfoDTO;
import com.esakki.ticketreserve.model.dto.TheaterSeatDTO;
import com.esakki.ticketreserve.model.entity.Seat;
import com.esakki.ticketreserve.model.entity.Theater;
import com.esakki.ticketreserve.repository.SeatRepository;
import com.esakki.ticketreserve.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Service
public class TheaterSearviceImpl implements TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Optional<Theater> getTheaterById(Long id) {
        return theaterRepository.findById(id);
    }

    @Override
    @Transactional
    public Theater createTheater(TheaterSeatDTO theaterSeatDTO) {
        Theater theaterSave = new Theater(theaterSeatDTO.getName());
        theaterSave.setCreatedAt(LocalDateTime.now());
        theaterSave.setUpdatedAt(LocalDateTime.now());
        Theater theater = theaterRepository.save(theaterSave);
        List<Seat> seatList = seatInfoToSeat(theaterSeatDTO.getSeatInfo());
        seatList.forEach(seat -> {
            seat.setTheater(theaterSave);
            seatRepository.save(seat);
        });
        return theater;
    }

    @Override
    public Iterable<Seat> getSeatListByTheater(Long theaterId) {
        return seatRepository.findAllByTheaterTest(theaterId);
    }



    private static List<Seat> seatInfoToSeat(HashMap<String, SeatInfoDTO> seatInfoDTOHashMap) {
        return seatInfoDTOHashMap.entrySet().stream().map((seatInfo) -> {
           String row = seatInfo.getKey();
           int numberOfSeats = seatInfo.getValue().getNumberOfSeats();
           int[] aisleSeats = seatInfo.getValue().getAisleSeats();
           List<Seat> seats = new ArrayList<>();
            for (int i = 1; i <= numberOfSeats; i++) {
                Seat s = new Seat();
                s.setSeatRow(row);
                s.setSeatNo(i);
                int finalI = i;
                s.setAisle(IntStream.of(aisleSeats).anyMatch(x -> finalI == x));
                s.setCreatedAt(LocalDateTime.now());
                s.setUpdatedAt(LocalDateTime.now());
                seats.add(s);
            }
            return seats;
        }).flatMap(List::stream).collect(toList());
    }
}
