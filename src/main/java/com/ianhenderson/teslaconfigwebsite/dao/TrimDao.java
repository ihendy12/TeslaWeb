package com.ianhenderson.teslaconfigwebsite.dao;

import com.ianhenderson.teslaconfigwebsite.model.Trim;

public interface TrimDao {

    Trim getTrim(int trimId);

    Trim getTrimName(String trimName);

    Trim createTrim(Trim newTrim);
}
