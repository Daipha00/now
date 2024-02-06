package com.example.my_licence.model;

import jakarta.persistence.*;
import lombok.Data;

//import java.util.List;
 //extends  Vehicle

@Entity
@Data

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cust_id;
    private String fullname;
    private String address;
    private String bloodgroup;
    private int age;



    public Customer(int cust_id, String fullname, String address, String bloodgroup, int age) {
        this.cust_id = cust_id;
        this.fullname = fullname;
        this.address = address;
        this.bloodgroup = bloodgroup;
        this.age = age;
    }

    public Customer(){

    }


    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}