package com.ianhenderson.teslaconfigwebsite.dao;

import com.ianhenderson.teslaconfigwebsite.model.Tow;

import java.util.List;

public interface TowDao {
    Tow getTow(int towId);
    Tow getTowName(String towName);

    List<Tow> getTowOptions();
}
