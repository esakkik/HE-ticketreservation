package com.esakki.ticketreserve.model.dto;

import java.util.HashMap;

public class TheaterSeatDTO {
    private String name;
    private HashMap<String, SeatInfoDTO> seatInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, SeatInfoDTO> getSeatInfo() {
        return seatInfo;
    }

    public void setSeatInfo(HashMap<String, SeatInfoDTO> seatInfo) {
        this.seatInfo = seatInfo;
    }
}
