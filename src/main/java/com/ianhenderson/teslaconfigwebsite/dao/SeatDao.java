package com.ianhenderson.teslaconfigwebsite.dao;

import com.ianhenderson.teslaconfigwebsite.model.Seat;

import java.util.List;

public interface SeatDao {
    Seat getSeat(int seatId);
    Seat getSeatName(String seatName);

    List<Seat> getAllSeats();
}
