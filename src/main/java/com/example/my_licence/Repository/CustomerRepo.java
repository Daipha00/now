package com.example.my_licence.Repository;

import com.example.my_licence.model.Customer;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
//    Customer findByFullname(String fullname);
}
