package com.example.my_licence.controller;


import com.example.my_licence.Repository.VehicleRepo;
import com.example.my_licence.Services.VclassServices;
import com.example.my_licence.Services.VehicleServices;
import com.example.my_licence.model.Vclass;
import com.example.my_licence.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.my_licence.exception.ResourceNotFoundException;

import java.util.List;
    @RequestMapping("/api/v1/vehicle")
    @RestController
    @CrossOrigin(origins = "*")
    public class VehicleController {

        @Autowired
        private VehicleServices vehicleServices;

        @GetMapping("/all")
        public List<Vehicle>getAll(){return vehicleServices.getAll();}

        @GetMapping("/{id}")
        public Vehicle getVehicleById(@PathVariable Integer id){
            return vehicleServices.getVehicleById(id);
        }

        @PostMapping("/save")
        public void create(@RequestBody Vehicle vehicle){
            vehicleServices.create(vehicle);
        }

        @PutMapping("/{id}")
        public void updateVehicle(@PathVariable Integer id,@RequestBody Vehicle vehicle){
            vehicleServices.updateVehicle(id,vehicle);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Integer id){vehicleServices.delete(id);}


    }





