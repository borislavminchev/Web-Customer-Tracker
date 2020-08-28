package com.borislavmm.controller;

import com.borislavmm.entity.Customer;
import com.borislavmm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/")
    public String redirect(){
        return "redirect:list";
    }

    @GetMapping("/list")
    public String listCustomers(Model model){
        List<Customer> customers = service.getCustomers();
        customers.sort((c1, c2) ->{
            return c1.getLastName().compareTo(c2.getLastName());
        });
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String addForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String SaveCustomer(@ModelAttribute("customer") Customer customer){
        service.saveCustomer(customer);
        return "redirect:list";
    }

    @GetMapping("showForUpdate")
    public String showUpdateCustomerForm(@RequestParam("id") long id, Model model){
        model.addAttribute("customer", service.getCustomerById(id));
        return "customer-form";
    }

    @GetMapping("showForDelete")
    public String deleteCustomerFromForm(@RequestParam("id") long id, Model model){
        service.deleteCustomerById(id);
        return "redirect:list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String searchName, Model theModel) {

        List<Customer> customers = service.searchCustomers(searchName);
        theModel.addAttribute("customers", customers);

        return "list-customers";
    }


}
