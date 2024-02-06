package com.example.my_licence.Services;

import com.example.my_licence.Repository.CustomerRepo;
import com.example.my_licence.Repository.LicenceRepo;
import com.example.my_licence.model.Customer;
import com.example.my_licence.model.Licence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenceServices {
    @Autowired

    private LicenceRepo licenceRepo;

    public List<Licence> getAll() {return licenceRepo.findAll();}

    public Licence getLicenceById(int id){return licenceRepo.findById(id).orElse(null);}

    public void create(Licence licence){ licenceRepo.save(licence); }

    public void updateLicence(Integer id, Licence licence){
        Licence existingLicence = licenceRepo.findById(id).orElse(null);
        if (existingLicence !=null){
            existingLicence.setStartdate(licence.getStartdate());
            licenceRepo.save(existingLicence);
        }
    }
    public void delete(Integer id){licenceRepo.deleteById(id);}

}



