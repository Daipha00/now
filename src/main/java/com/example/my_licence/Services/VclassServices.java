package com.example.my_licence.Services;

import com.example.my_licence.Repository.StaffRepo;
import com.example.my_licence.Repository.VclassRepo;
import com.example.my_licence.model.Staff;
import com.example.my_licence.model.Vclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VclassServices {

    @Autowired
    private VclassRepo vclassRepo;

    public List<Vclass> getAll() {return vclassRepo.findAll();}

    public Vclass getVclassById(int id){return vclassRepo.findById(id).orElse(null);}

    public void create(Vclass vclass){ vclassRepo.save(vclass); }

    public void updateVclass(Integer id, Vclass vclass){
        Vclass existingVclass = vclassRepo.findById(id).orElse(null);
        if (existingVclass !=null){
            existingVclass.setClassname(vclass.getClassname());
           vclassRepo.save(existingVclass);
        }
    }
    public void delete(Integer id){vclassRepo.deleteById(id);}

}






