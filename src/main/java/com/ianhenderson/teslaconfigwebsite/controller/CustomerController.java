package com.ianhenderson.teslaconfigwebsite.controller;
import com.ianhenderson.teslaconfigwebsite.dao.CustomerDao;
import com.ianhenderson.teslaconfigwebsite.dao.JdbcCustomerDao;
import com.ianhenderson.teslaconfigwebsite.model.Customer;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private JdbcCustomerDao customerDao;

    public CustomerController(){

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/TeslaConfigurator");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Fall2022!");

        customerDao = new JdbcCustomerDao(dataSource);
        try {
            dataSource.getConnection();
            System.out.println("Successful!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping (path = "", method = RequestMethod.GET)
    public List<Customer> customerList(){
        return customerDao.getAllCustomerOrders();
    }
}
