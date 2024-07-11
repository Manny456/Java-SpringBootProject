package org.example.Controllers;

import org.example.MainClasses.Customers;
import org.example.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    public CustomerService customerService;

    @Autowired
    public CustomerController (CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/getAll")
    public List<Customers> retrieveAllCustomers () {
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/getById/{id}")
    public Optional<Customers> retrieveById (@PathVariable ("id") Long customerId) {
        return customerService.getById(customerId);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countJobData() {
        long count = customerService.countJobData();
        return ResponseEntity.ok(count);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> customerToDelete(@PathVariable ("id") Long customerId) {
        return customerService.deleteCustomerById(customerId);
    }
}
