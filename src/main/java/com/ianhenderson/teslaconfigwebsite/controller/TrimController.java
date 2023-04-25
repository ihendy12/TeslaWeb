package com.ianhenderson.teslaconfigwebsite.controller;

import com.ianhenderson.teslaconfigwebsite.dao.JdbcAutopilotDao;
import com.ianhenderson.teslaconfigwebsite.dao.JdbcTrimDao;
import com.ianhenderson.teslaconfigwebsite.model.Autopilot;
import com.ianhenderson.teslaconfigwebsite.model.Trim;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trims")
public class TrimController {
    private JdbcTrimDao trimDao;

    public TrimController(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/TeslaConfigurator");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Fall2022!");

        trimDao = new JdbcTrimDao(dataSource);
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    List<Trim> allTrims(){
        return trimDao.getAllTrims();
    }

}
