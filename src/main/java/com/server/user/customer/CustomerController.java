package com.server.user.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Post Customer
    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        int result = customerRepository.createCustomer(customer);

        if (result > 0){
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer Created Successfully");
        }

        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating customer");
        }
    }

}
