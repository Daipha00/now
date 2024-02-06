package com.example.my_licence.controller;


import com.example.my_licence.Repository.VclassRepo;
import com.example.my_licence.Services.StaffServices;
import com.example.my_licence.Services.VclassServices;
import com.example.my_licence.model.Staff;
import com.example.my_licence.model.Vclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.my_licence.exception.ResourceNotFoundException;

import java.util.List;

    @ComponentScan
    @RestController
    @CrossOrigin
    @RequestMapping("/api/v1/vclass")

    public class VclassController {
        @Autowired
        private VclassServices vclassServices;

        @GetMapping("/all")
        public List<Vclass>getAll(){return vclassServices.getAll();}

        @GetMapping("/{id}")
        public Vclass getVclassById(@PathVariable Integer id){
            return vclassServices.getVclassById(id);
        }

        @PostMapping("/save")
        public void create(@RequestBody Vclass vclass){
            vclassServices.create(vclass);
        }

        @PutMapping("/{id}")
        public void updateVclass(@PathVariable Integer id,@RequestBody Vclass vclass){
           vclassServices.updateVclass(id,vclass);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Integer id){vclassServices.delete(id);}



    }

