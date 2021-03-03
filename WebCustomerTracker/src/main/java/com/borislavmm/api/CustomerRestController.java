package com.borislavmm.api;

import com.borislavmm.entity.Customer;
import com.borislavmm.exceptions.CustomerNotFoundException;
import com.borislavmm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getSingleCustomer(@PathVariable long id){
        Customer customer = null;

        try {
            customer = customerService.getCustomerById(id);
        }catch (NoSuchElementException e){
            throw new CustomerNotFoundException("Customer id is not found: " + id);
        }

        return customer;
    }

}
