package com.cliffgor.crud.repository;

import com.cliffgor.crud.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> searchByFirstName(String name);
    List<Customer> searchByBalance(double balance);

    List<Customer> searchByAvailable(boolean available);

}
