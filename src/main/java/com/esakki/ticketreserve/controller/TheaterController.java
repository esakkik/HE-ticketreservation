package com.esakki.ticketreserve.controller;

import com.esakki.ticketreserve.exception.TheaterNotFoundException;
import com.esakki.ticketreserve.model.dto.TheaterSeatDTO;
import com.esakki.ticketreserve.model.entity.Seat;
import com.esakki.ticketreserve.model.entity.Theater;
import com.esakki.ticketreserve.service.TheaterService;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/screens")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Theater getTheaterById(@PathVariable("id") Long id) {
        return theaterService.getTheaterById(id).orElseThrow(() -> new TheaterNotFoundException("Theater Not Found")) ;
    }

    @GetMapping(value = "/{id}/seats", produces = "application/json")
    public Iterable<Seat> getSeatsByTheater(@PathVariable("id") Long id) {
        return theaterService.getSeatListByTheater(id);
    }

    @PostMapping(value = "/", produces = "application/json", consumes = "application/json")
    public Theater createTheater(@RequestBody TheaterSeatDTO theaterSeatDTO) {
        return theaterService.createTheater(theaterSeatDTO);
    }
}
