package com.cliffgor.crud.controller;

import com.cliffgor.crud.dto.CustomerRequest;
import com.cliffgor.crud.model.Customer;
import com.cliffgor.crud.service.CustomerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CustomerController {

    CustomerService customerService;

    @PostMapping("/dto/save")
   public ResponseEntity<Customer> saveCustomerDto(@RequestBody CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setAvailable(customerRequest.isAvailable());
        customer.setBalance(customerRequest.getBalance());
        return new ResponseEntity<>(customerService.saveCustomer(customer),HttpStatus.CREATED);
    }
    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer  customer){
        return new ResponseEntity<>(customerService.saveCustomer(customer),HttpStatus.CREATED);
    }

    @PostMapping("/save/all")
    public List<Customer> saveCustomers(@RequestBody List<Customer> customers){
        return customerService.saveCustomers(customers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/allCustomers")
    public List<Customer> allCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/search/{name}")
    public List<Customer> getCustomerByFirstName(@PathVariable String name){
        return customerService.searchByName(name);
    }

    @GetMapping("/account/{balance}")
    public List<Customer> searchByBalance(@PathVariable double balance){
        return customerService.searchByAccountBalance(balance);
    }

    @GetMapping("/available/{available}")
    public List<Customer> getAvailability(@PathVariable boolean available){
        return customerService.searchByAvailability(available);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
        return new ResponseEntity<>(customerService.updateCustomerDetails(customer,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer Deleted successfully",HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteCustomers(){
        customerService.deleteAll();
        return new ResponseEntity<>("Database cleared..",HttpStatus.OK);
    }



}
