package com.ianhenderson.teslaconfigwebsite.controller;

import com.ianhenderson.teslaconfigwebsite.dao.JdbcAutopilotDao;
import com.ianhenderson.teslaconfigwebsite.dao.JdbcTowDao;
import com.ianhenderson.teslaconfigwebsite.model.Autopilot;
import com.ianhenderson.teslaconfigwebsite.model.Tow;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/tows")
public class TowController {
    private JdbcTowDao towDao;

    public TowController(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/TeslaConfigurator");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Fall2022!");

        towDao = new JdbcTowDao(dataSource);
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    List<Tow> allTows(){
        return towDao.getTowOptions();
    }
}
