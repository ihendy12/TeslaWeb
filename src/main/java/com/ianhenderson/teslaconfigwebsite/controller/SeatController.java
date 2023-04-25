package com.ianhenderson.teslaconfigwebsite.controller;

import com.ianhenderson.teslaconfigwebsite.dao.JdbcAutopilotDao;
import com.ianhenderson.teslaconfigwebsite.dao.JdbcSeatDao;
import com.ianhenderson.teslaconfigwebsite.model.Autopilot;
import com.ianhenderson.teslaconfigwebsite.model.Seat;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/seats")
public class SeatController {
    private JdbcSeatDao seatDao;

    public SeatController(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/TeslaConfigurator");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Fall2022!");

        seatDao = new JdbcSeatDao(dataSource);
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    List<Seat> allSeats(){
        return seatDao.getAllSeats();
    }
}

