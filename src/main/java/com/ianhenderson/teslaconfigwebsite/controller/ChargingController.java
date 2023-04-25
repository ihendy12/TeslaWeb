package com.ianhenderson.teslaconfigwebsite.controller;

import com.ianhenderson.teslaconfigwebsite.dao.JdbcChargingDao;
import com.ianhenderson.teslaconfigwebsite.model.Charging;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/charging")
public class ChargingController {
    private JdbcChargingDao chargingDao;

    public ChargingController(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/TeslaConfigurator");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Fall2022!");

        chargingDao = new JdbcChargingDao(dataSource);
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    List<Charging> allCharging(){
        return chargingDao.getAllCharging();
    }
}

