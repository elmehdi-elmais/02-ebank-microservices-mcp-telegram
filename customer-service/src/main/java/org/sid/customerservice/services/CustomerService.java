package org.sid.customerservice.services;

import lombok.AllArgsConstructor;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author EL Mehdi EL MAIS
 */
@Service
@AllArgsConstructor
public class CustomerService {
    private  CustomerRepository customerRepository;
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->  new RuntimeException("Customer not found"));

    }
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);

    }
}
