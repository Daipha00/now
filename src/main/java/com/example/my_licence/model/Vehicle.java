package com.example.my_licence.model;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
//@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicle_id;
    private int model;


//    @ManyToOne
//    @JoinColumn(name = "cust_id")
//    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "vclass_id")
//    private Vclass vclass;

    public Vehicle(int vehicle_id, int model) {
        this.vehicle_id = vehicle_id;
        this.model = model;
    }
    public Vehicle(){

    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }




}