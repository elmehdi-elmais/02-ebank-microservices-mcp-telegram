package org.sid.customerservice.services;

import lombok.AllArgsConstructor;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author EL Mehdi EL MAIS
 */
@Service
@AllArgsConstructor
public class CustomerService {
    private  CustomerRepository customerRepository;
    @McpTool(description = "Get all customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    @McpTool(description = "Find customer by ID")
    public Customer findCustomerById(@McpToolParam(description = "The customer ID") Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->  new RuntimeException("Customer not found"));

    }
    @McpTool(description = "Save a new customer")
    public Customer saveCustomer(@McpToolParam(description = "The customer to save(name, email)") Customer customer) {
        return customerRepository.save(customer);

    }
}
