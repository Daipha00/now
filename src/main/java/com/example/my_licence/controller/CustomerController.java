package com.example.my_licence.controller;

import com.example.my_licence.Services.CustomerServices;
import com.example.my_licence.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/customer")
    public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/cust")
public List<Customer>getAll(){
        return customerServices.getAll();}

@GetMapping("/cust/{id}")
public Customer getCustomerById(@PathVariable Integer id){
        return customerServices.getCustomerById(id);
}

//    @GetMapping("/cust/{fullname}")
//    public Customer getCustomerByFullname(@PathVariable String fullname) {
//        return customerServices.getCustomerByFullname(fullname);
//    }

@PostMapping("/cust")
    public void create(@RequestBody Customer customer){
        customerServices.create(customer);
}

@PutMapping("/cust/{cust_id}")
    public void updateCustomer(@PathVariable Integer cust_id,@RequestBody Customer customer){
        customerServices.updateCustomer(cust_id,customer);
}

@DeleteMapping("/cust/{id}")
    public void delete(@PathVariable Integer id){customerServices.delete(id);}






    }


