package com.cliffgor.crud.service;

import com.cliffgor.crud.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> saveCustomers(List<Customer> customers);

    Customer getById(Long id);

    List<Customer> searchByAccountBalance(double balance);

    List<Customer> getAllCustomers();

    List<Customer> searchByName(String name);

    List<Customer> searchByAvailability(boolean available);

    Customer updateCustomerDetails(Customer customer, Long id);

    void deleteCustomer(Long id);

    void deleteAll();



}
