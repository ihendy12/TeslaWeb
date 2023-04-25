package com.ianhenderson.teslaconfigwebsite.controller;

import com.ianhenderson.teslaconfigwebsite.dao.JdbcAutopilotDao;
import com.ianhenderson.teslaconfigwebsite.dao.JdbcExteriorDao;
import com.ianhenderson.teslaconfigwebsite.model.Autopilot;
import com.ianhenderson.teslaconfigwebsite.model.Exterior;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/exteriors")
public class ExteriorController {
    private JdbcExteriorDao exteriorDao;

    public ExteriorController(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/TeslaConfigurator");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Fall2022!");

        exteriorDao = new JdbcExteriorDao(dataSource);
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    List<Exterior> allExteriors(){
        return exteriorDao.getAllExteriors();
    }
}

