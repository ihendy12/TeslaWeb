package com.ianhenderson.teslaconfigwebsite.controller;

import com.ianhenderson.teslaconfigwebsite.dao.InteriorDao;
import com.ianhenderson.teslaconfigwebsite.dao.JdbcAutopilotDao;
import com.ianhenderson.teslaconfigwebsite.dao.JdbcInteriorDao;
import com.ianhenderson.teslaconfigwebsite.model.Autopilot;
import com.ianhenderson.teslaconfigwebsite.model.Interior;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/interiors")
public class InteriorController {
    private JdbcInteriorDao interiorDao;

    public InteriorController(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/TeslaConfigurator");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Fall2022!");

        interiorDao = new JdbcInteriorDao(dataSource);
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    List<Interior> allInteriors(){ return interiorDao.getAllInteriors();
    }
}
