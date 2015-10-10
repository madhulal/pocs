package org.mare.pos.controller;

import org.mare.pos.domain.Customer;
import org.mare.pos.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Madhulal M G on 10/10/15.
 */
@RestController // assumes @ResponseBody annotation in methods annotated with  @RequestMapping
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    protected CustomerRepository customerRepository;

    public Iterable<Customer> customers() {
        return customerRepository.findAll(); 
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody Customer Customer(@PathVariable("id") long id) {
        Customer customer = customerRepository.findOne(id);
        return customer;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable("id") long id) {
        try {
            customerRepository.delete(id);
            return String.format("Customer [%s] successfully deleted", id);
        } catch (Exception e) {
            return String.format("A problem occurred when deleting Customer [%s]", e.getMessage());
        }
    }

    @RequestMapping("/customer/{lastName}")
    public Iterable<Customer> customersByLastName(@PathVariable("lastName") String lastName) {
        return customerRepository.findByLastName(lastName);
    }
}
