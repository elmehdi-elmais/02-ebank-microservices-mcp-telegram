package org.sid.ebankservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.sid.ebankservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author EL Mehdi EL MAIS
 */

@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    @GetMapping("/customer/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable("id") Long id);

    @GetMapping("/customers")
    List<Customer> getAllCustomers();

    default Customer getDefaultCustomer(Long id, Throwable throwable) {
        return new Customer(id, "Default Customer", "default-email@example.com");
    }
}