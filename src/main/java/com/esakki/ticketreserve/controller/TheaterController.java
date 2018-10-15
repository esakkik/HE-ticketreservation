package com.esakki.ticketreserve.controller;

import com.esakki.ticketreserve.exception.TheaterNotFoundException;
import com.esakki.ticketreserve.model.entity.Theater;
import com.esakki.ticketreserve.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Theater getTheaterById(@PathVariable("id") Long id) {
        return theaterService.getTheaterById(id).orElseThrow(TheaterNotFoundException::new);
    }

    @PostMapping(value = "/", produces = "application/json", consumes = "application/json")
    public Theater createTheater(@RequestBody String name) {
        return theaterService.createTheater(name);
    }
}
