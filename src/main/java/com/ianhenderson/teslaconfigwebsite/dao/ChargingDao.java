package com.ianhenderson.teslaconfigwebsite.dao;

import com.ianhenderson.teslaconfigwebsite.model.Charging;

import java.util.List;

public interface ChargingDao {
    Charging getCharging(int chargingId);
    Charging getChargingName(String chargingName);

    List<Charging> getAllCharging();
}
