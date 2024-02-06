package com.example.my_licence.controller;

import com.example.my_licence.Repository.LicenceRepo;
import com.example.my_licence.Services.CustomerServices;
import com.example.my_licence.Services.LicenceServices;
import com.example.my_licence.model.Customer;
import com.example.my_licence.model.Licence;
import com.example.my_licence.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RestController
@CrossOrigin
@RequestMapping("/api/v1/licence")
public class LicenceController {
    @Autowired
    private LicenceServices licenceServices;

    @GetMapping("/all")
    public List<Licence>getAll(){return licenceServices.getAll();}

    @GetMapping("/{id}")
    public Licence getLicenceById(@PathVariable Integer id){
        return licenceServices.getLicenceById(id);
    }

    @PostMapping("/save")
    public void create(@RequestBody Licence licence){
        licenceServices.create(licence);
    }

    @PutMapping("/{id}")
    public void updateLicence(@PathVariable Integer id,@RequestBody Licence licence){
        licenceServices.updateLicence(id,licence);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){licenceServices.delete(id);}





}
