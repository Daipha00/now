package com.example.my_licence.Repository;

import com.example.my_licence.model.Licence;
import com.example.my_licence.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenceRepo extends JpaRepository<Licence, Integer> {
}
