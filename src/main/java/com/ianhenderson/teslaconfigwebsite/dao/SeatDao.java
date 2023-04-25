package com.ianhenderson.teslaconfigwebsite.dao;

import com.ianhenderson.teslaconfigwebsite.model.Seat;

public interface SeatDao {
    Seat getSeat(int seatId);
    Seat getSeatName(String seatName);
}
