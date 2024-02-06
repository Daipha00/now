package com.example.my_licence.Services;


import com.example.my_licence.Repository.StaffRepo;
import com.example.my_licence.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class StaffServices {
        @Autowired
        private StaffRepo staffRepo;

        public List<Staff> getAll() {return staffRepo.findAll();}

        public Staff getStaffById(int id){return staffRepo.findById(id).orElse(null);}

        public void create(Staff staff){ staffRepo.save(staff); }

        public void updateStaff(Integer id, Staff staff){
            Staff existingStaff = staffRepo.findById(id).orElse(null);
            if (existingStaff !=null){
                existingStaff.setFullname(staff.getFullname());
                staffRepo.save(existingStaff);
            }
        }
        public void delete(Integer id){staffRepo.deleteById(id);}

    }




