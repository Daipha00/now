package com.example.my_licence.Services;

import com.example.my_licence.Repository.VclassRepo;
import com.example.my_licence.Repository.VehicleRepo;
import com.example.my_licence.model.Vclass;
import com.example.my_licence.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServices {

    @Autowired
    private VehicleRepo vehicleRepo;

    public List<Vehicle> getAll() {return vehicleRepo.findAll();}

    public Vehicle getVehicleById(int id){return vehicleRepo.findById(id).orElse(null);}

    public void create(Vehicle vehicle){ vehicleRepo.save(vehicle); }

    public void updateVehicle(Integer id, Vehicle vehicle){
        Vehicle existingVehicle = vehicleRepo.findById(id).orElse(null);
        if (existingVehicle !=null){
            existingVehicle.setModel(vehicle.getModel());
            vehicleRepo.save(existingVehicle);
        }
    }
    public void delete(Integer id){vehicleRepo.deleteById(id);}

}
