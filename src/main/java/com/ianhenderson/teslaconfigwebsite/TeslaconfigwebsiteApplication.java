package com.ianhenderson.teslaconfigwebsite;

import com.ianhenderson.teslaconfigwebsite.controller.CustomerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.swing.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TeslaconfigwebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeslaconfigwebsiteApplication.class, args);
	}
			CustomerController customerController = new CustomerController();

	public CustomerController getCustomerController() {
		return customerController;
	}

}
