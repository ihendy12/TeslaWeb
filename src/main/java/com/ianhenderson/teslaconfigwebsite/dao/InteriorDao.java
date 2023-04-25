package com.ianhenderson.teslaconfigwebsite.dao;

import com.ianhenderson.teslaconfigwebsite.model.Interior;

import java.util.List;

public interface InteriorDao {
    Interior getInterior(int interiorId);

    Interior getInteriorName(String interiorName);

    List<Interior> getAllInteriors();

    Interior createInterior(Interior newInterior);
}
