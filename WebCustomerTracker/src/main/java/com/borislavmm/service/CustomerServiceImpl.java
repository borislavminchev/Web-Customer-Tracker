package com.borislavmm.service;

import com.borislavmm.entity.Customer;
import com.borislavmm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    @Transactional
    public Customer getCustomerById(long id) {
        return repository.findById(id).get();
    }


    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        repository.save(customer);
    }

    @Override
    @Transactional
    public void deleteCustomerById(long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String searchName) {
        return repository.findCustomers(searchName);
    }
}
