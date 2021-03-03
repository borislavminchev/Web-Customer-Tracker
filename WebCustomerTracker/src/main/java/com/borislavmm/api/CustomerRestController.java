package com.borislavmm.api;

import com.borislavmm.entity.Customer;
import com.borislavmm.exceptions.AlreadyExistingCustomerException;
import com.borislavmm.exceptions.CustomerNotFoundException;
import com.borislavmm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/customers")
    public Customer addSingleCustomer(@RequestBody Customer customer){


        //throw new AlreadyExistingCustomerException("Customer is already existing");
        List<Customer> all = customerService.getCustomers();
        for (Customer c : all) {
            if(c.getId() == customer.getId()){
                throw new AlreadyExistingCustomerException("Customer is already existing");
            }
        }

        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateSingleCustomer(@RequestBody Customer customer){

        List<Customer> all = customerService.getCustomers();
        boolean flag = false;
        for (Customer c : all) {
            if(c.getId() == customer.getId()){
                flag = true;
            }
        }
        if(flag){
            customerService.saveCustomer(customer);
        }else {
            throw new CustomerNotFoundException("Customer not found to update: " + customer.getId());
        }

        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable long id){
        Customer temp = null;
        try{
            temp = customerService.getCustomerById(id);
        }catch (NoSuchElementException e){
            throw new CustomerNotFoundException("Customer id not found: " + id);
        }

        customerService.deleteCustomerById(id);

        return "Deleted customer id: " + id;
    }


}
