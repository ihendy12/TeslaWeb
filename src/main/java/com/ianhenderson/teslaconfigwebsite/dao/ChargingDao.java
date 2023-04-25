package com.ianhenderson.teslaconfigwebsite.dao;

import com.ianhenderson.teslaconfigwebsite.model.Charging;

public interface ChargingDao {
    Charging getCharging(int chargingId);
    Charging getChargingName(String chargingName);
}
