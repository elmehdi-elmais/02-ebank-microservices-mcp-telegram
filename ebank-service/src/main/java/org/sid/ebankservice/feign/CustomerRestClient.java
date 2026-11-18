package org.sid.ebankservice.feign;

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
    Customer getCustomerById(@PathVariable("id") Long id);

    @GetMapping("/customers")
    List<Customer> getAllCustomers();
}
