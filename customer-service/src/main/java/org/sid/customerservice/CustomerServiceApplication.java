package org.sid.customerservice;

import lombok.AllArgsConstructor;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@AllArgsConstructor
public class CustomerServiceApplication {
    private CustomerService customerService;
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner run(){
        return args -> {
            Stream<Customer> customerStream = Stream.<Customer>of(
                    new Customer(null, "Bono", "bono@gmail.com"),
                    new Customer(null, "Hakimi", "hakimi@gmail.com"),
                    new Customer(null, "Ziyach", "ziyach@gmail.com"),
                    new Customer(null, "Diaz", "diaz@gmail.com")

                    );
            customerStream.forEach(customer -> customerService.saveCustomer(customer));
        };
    }
}
