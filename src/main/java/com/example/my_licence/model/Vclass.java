package com.example.my_licence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Vclass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vclass_id;
    private String classname;

    public Vclass(int vclass_id, String classname) {
        this.vclass_id = vclass_id;
        this.classname = classname;
    }
    public Vclass(){

    }

    public int getVclass_id() {
        return vclass_id;
    }

    public void setVclass_id(int vclass_id) {
        this.vclass_id = vclass_id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}