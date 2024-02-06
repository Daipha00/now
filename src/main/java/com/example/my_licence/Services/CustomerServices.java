package com.example.my_licence.Services;

import com.example.my_licence.Repository.CustomerRepo;
import com.example.my_licence.model.Customer;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getAll() {return customerRepo.findAll();}

    public Customer getCustomerById(int id){return customerRepo.findById(id).orElse(null);}
//
//   public Customer getCustomerByFullname(String fullname){return  customerRepo.findByFullname(fullname);}

    public void create(Customer customer){ customerRepo.save(customer); }

    public void updateCustomer(Integer cust_id, Customer customer){
        Customer existingCustomer = customerRepo.findById(cust_id).orElse(null);
        if (existingCustomer !=null){
            existingCustomer.setAddress(customer.getAddress());
            existingCustomer.setAge(customer.getAge());
            existingCustomer.setBloodgroup(customer.getBloodgroup());
            existingCustomer.setFullname(customer.getFullname());
//            existingCustomer.setModel(customer.getModel());
            customerRepo.save(existingCustomer);
        }
    }

//    public Customer getUserByFullname(String fullname) {
//        return CustomerRepo.findByFullname(fullname);
//    }

    public void delete(Integer id){customerRepo.deleteById(id);}

}

