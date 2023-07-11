package com.cliffgor.crud.service.impl;

import com.cliffgor.crud.exceptions.ResourceNotFound;
import com.cliffgor.crud.model.Customer;
import com.cliffgor.crud.repository.CustomerRepository;
import com.cliffgor.crud.service.CustomerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CustomerImpl  implements CustomerService {

    CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> saveCustomers(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("Name","ID",id));
    }

    @Override
    public List<Customer> searchByAccountBalance(double balance) {
        return customerRepository.searchByBalance(balance);
    }
    @Override
    public List<Customer> searchByAvailability(boolean available) {
        return customerRepository.searchByAvailable(available);
    }


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> searchByName(String name) {
        return customerRepository.searchByFirstName(name);
    }



    @Override
    public Customer updateCustomerDetails(Customer customer, Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Name","ID",id));
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setAvailable(customer.isAvailable());
        existingCustomer.setBalance(customer.getBalance());
        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("%s Not found","ID",id));
        customerRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }


}
