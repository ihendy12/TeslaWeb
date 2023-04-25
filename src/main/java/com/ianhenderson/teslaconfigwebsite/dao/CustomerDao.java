package com.ianhenderson.teslaconfigwebsite.dao;


import com.ianhenderson.teslaconfigwebsite.model.Customer;

import java.util.List;


public interface CustomerDao {
    Customer createCustomer(Customer newCustomer);

    Customer getCustomerById(int customerId);

    public List<Customer> getAllCustomerOrders();


}