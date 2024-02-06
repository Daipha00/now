package com.example.my_licence.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Licence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int licence_id;
    private String expirydate;
    private String startdate;

    public Licence(int licence_id, String expirydate, String startdate) {
        this.licence_id = licence_id;
        this.expirydate = expirydate;
        this.startdate = startdate;
    }
    public Licence(){

    }

    public int getLicence_id() {
        return licence_id;
    }

    public void setLicence_id(int licence_id) {
        this.licence_id = licence_id;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
}