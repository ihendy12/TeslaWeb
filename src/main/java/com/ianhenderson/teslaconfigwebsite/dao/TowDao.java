package com.ianhenderson.teslaconfigwebsite.dao;

import com.ianhenderson.teslaconfigwebsite.model.Tow;

public interface TowDao {
    Tow getTow(int towId);
    Tow getTowName(String towName);
}
