package com.example.my_licence.controller;


import com.example.my_licence.Services.StaffServices;
import com.example.my_licence.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RestController
@CrossOrigin
@RequestMapping("/api/v1/staff")
public class StaffController {

    @Autowired
    private StaffServices staffServices;

    @GetMapping("/all")
    public List<Staff>getAll(){return staffServices.getAll();}

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable Integer id){
        return staffServices.getStaffById(id);
    }

    @PostMapping("/save")
    public void create(@RequestBody Staff staff){
       staffServices.create(staff);
    }

    @PutMapping("/{id}")
    public void updateStaff(@PathVariable Integer id,@RequestBody Staff staff){
        staffServices.updateStaff(id,staff);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){staffServices.delete(id);}



}
