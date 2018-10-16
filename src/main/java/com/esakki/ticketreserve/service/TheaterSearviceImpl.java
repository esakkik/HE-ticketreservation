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

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Service
public class TheaterSearviceImpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    SeatRepository seatRepository;

    @Override
    public Optional<Theater> getTheaterById(Long id) {
        return theaterRepository.findById(id);
    }

    @Override
    @Transactional
    public Theater createTheater(TheaterSeatDTO theaterSeatDTO) {
        Theater theaterSave = new Theater(theaterSeatDTO.getName());
        System.out.println("------------------------- 111THEATER ID --------------------" + theaterSave.getName());
        Theater theater = theaterRepository.save(theaterSave);
        System.out.println("------------------------- 2222THEATER ID --------------------" + theater.getId());
        List<Seat> seatList = seatInfoToSeat(theaterSeatDTO.getSeatInfo());
        System.out.println("------------------------- 3333THEATER ID --------------------" + seatList.get(1).getRow());
        seatList.forEach(seat -> {
            System.out.println("------------------------- THEATER ID --------------------" + theaterSave.getName());
            seat.setTheater(theaterSave);
            seatRepository.save(seat);
        });
        return theater;
    }

    @Override
    public Iterable<Seat> getSeatListByTheater(Long theaterId) {
        return seatRepository.findAll();
    }



    private static List<Seat> seatInfoToSeat(HashMap<String, SeatInfoDTO> seatInfoDTOHashMap) {
        return seatInfoDTOHashMap.entrySet().stream().map((seatInfo) -> {
           String row = seatInfo.getKey();
           int numberOfSeats = seatInfo.getValue().getNumberOfSeats();
           int[] aisleSeats = seatInfo.getValue().getAisleSeats();
           List<Seat> seats = new ArrayList<>();
            for (int i = 1; i <= numberOfSeats; i++) {
                System.out.println("---- => i" + seatInfo.getValue().getNumberOfSeats() + " ===== i = " + i);
                Seat s = new Seat();
                s.setRow(row);
                s.setColumn(i);
                int finalI = i;
                s.setAisle(IntStream.of(aisleSeats).anyMatch(x -> finalI == x));
                System.out.println("BEFORE NULL = " + s.getColumn());
                seats.add(s);
            }
            return seats;
        }).flatMap(List::stream).collect(toList());
    }
}
