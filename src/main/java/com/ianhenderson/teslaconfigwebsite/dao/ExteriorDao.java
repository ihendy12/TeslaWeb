package com.ianhenderson.teslaconfigwebsite.dao;

import com.ianhenderson.teslaconfigwebsite.model.Exterior;

import java.util.List;

public interface ExteriorDao {
    Exterior getExterior(int exteriorId);

    Exterior getExteriorName(String exteriorName);

    List<Exterior> getAllExteriors();

    Exterior createExterior(Exterior newExterior);
}
