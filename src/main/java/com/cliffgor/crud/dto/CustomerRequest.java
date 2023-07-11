package com.cliffgor.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    private Long id;
    private String firstName;
    private String lastName;
    private boolean available;
    private double balance;
}
