package com.ianhenderson.teslaconfigwebsite.controller;


import com.ianhenderson.teslaconfigwebsite.dao.JdbcModelDao;
import com.ianhenderson.teslaconfigwebsite.model.Model;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/models")
public class ModelController {
    private JdbcModelDao modelDao;

    public ModelController(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/TeslaConfigurator");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Fall2022!");

        modelDao = new JdbcModelDao(dataSource);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    List<Model> allModels(){
        return modelDao.getModels();
    }
}
