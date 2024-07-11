package org.example.Services;

import org.example.MainClasses.Customers;
import org.example.Repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    public CustomerRepository customerRepository;

    public long countJobData() {
        return customerRepository.countJobData();
    }

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customers> getById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public ResponseEntity<String> deleteCustomerById(Long customerId) {
        Optional<Customers> customerToDelete = customerRepository.findById(customerId);

        if (!customerToDelete.isPresent()) {
            return new ResponseEntity<>("Customer does not Exist.", HttpStatus.NOT_FOUND);
        }

        customerRepository.deleteById(customerId);
        return new ResponseEntity<>("Customer has been deleted", HttpStatus.OK);
    }
}
