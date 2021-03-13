package com.borislavmm.bootstrap;

import com.borislavmm.entity.Customer;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

//@Component
//public class BootstrapApp implements CommandLineRunner {
//    @Override
//    public void run(String... args) throws Exception {
//        Customer customer = WebClient.create("http://localhost:8080/api/customers").get().uri("/13")
//                .retrieve().bodyToMono(Customer.class).block();
//        System.out.println(customer.getId() + " " + customer.getFirstName() + " " + customer.getLastName());
//
//    }
//}
