package com.esakki.ticketreserve.model.dto;

import java.util.Arrays;

public class SeatInfoDTO {
    private int numberOfSeats;
    private int[] aisleSeats;

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        System.out.println("Setting setas : " + numberOfSeats);
        this.numberOfSeats = numberOfSeats;
    }

    public int[] getAisleSeats() {
        return aisleSeats;
    }

    public void setAisleSeats(int[] aisleSeats) {
        System.out.println("Setting setassssssssss : " + aisleSeats.length);
        this.aisleSeats = aisleSeats;
    }
}
