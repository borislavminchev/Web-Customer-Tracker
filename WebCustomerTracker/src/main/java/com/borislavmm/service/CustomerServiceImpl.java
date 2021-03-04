package com.borislavmm.service;

import com.borislavmm.entity.Customer;
import com.borislavmm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer getCustomerById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void deleteCustomerById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        return repository.findCustomers(searchName);
    }
}
