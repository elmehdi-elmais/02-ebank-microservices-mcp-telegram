package org.sid.customerservice.repositories;

import org.sid.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author EL Mehdi EL MAIS
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
