package com.borislavmm.repository;

import com.borislavmm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("from Customer where lower(firstName) like ?1 or lower(lastName) like ?1")
    List<Customer> findCustomers(String name);
}
