package com.borislavmm.service;

import com.borislavmm.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    Customer getCustomerById(long id);

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    void deleteCustomerById(long id);

    List<Customer> searchCustomers(String searchName);
}
