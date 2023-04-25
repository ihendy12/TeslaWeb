package com.ianhenderson.teslaconfigwebsite.dao;

import com.ianhenderson.teslaconfigwebsite.model.Wheel;

import java.util.List;

public interface WheelDao {

    Wheel getWheel(int wheelId);

    Wheel getWheelName(String wheelName);
    List<Wheel> getAllWheels();

    Wheel createWheel(Wheel newWheel);
}
