package com.example.my_licence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staff_id;
    private String fullname;
    private String address;

    public Staff(int staff_id, String fullname, String address) {
        this.staff_id = staff_id;
        this.fullname = fullname;
        this.address = address;
    }
    public Staff(){

    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
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
}