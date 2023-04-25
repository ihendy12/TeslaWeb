package com.ianhenderson.teslaconfigwebsite.dao;

import com.ianhenderson.teslaconfigwebsite.model.Trim;

import java.util.List;

public interface TrimDao {

    Trim getTrim(int trimId);

    Trim getTrimName(String trimName);

    Trim createTrim(Trim newTrim);

    List<Trim> getAllTrims();
}
