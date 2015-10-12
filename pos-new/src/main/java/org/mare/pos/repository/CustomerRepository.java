package org.mare.pos.repository;

/**
 * Created by Madhulal M G on 7/10/15.
 */

import org.mare.pos.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}