/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petcare_sheduler;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danuja
 */
public class Pet implements Serializable{
    
    private String pid;
    private String Name;
    private String Breed;
    private int age;
    private String ownername;
    private String contactinfo;
    private LocalDate registerdDate;
    private List<Appoinment> appoinments;
    
    Pet(String pid,String Name,String Breed,int age,String ownername,String contactinfo){
        this.age = age;
        this.Name = Name;
        this.Breed = Breed;
        this.contactinfo = contactinfo;
        this.ownername = ownername;
        this.appoinments = new ArrayList<>();
        this.registerdDate = LocalDate.now();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String Breed) {
        this.Breed = Breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo;
    }

    public LocalDate getRegisterdDate() {
        return registerdDate;
    }

    public void setRegisterdDate(LocalDate registerdDate) {
        this.registerdDate = registerdDate;
    }

    public List<Appoinment> getAppoinments() {
        return appoinments;
    }

    public void setAppoinments(List<Appoinment> appoinments) {
        this.appoinments = appoinments;
    }
    
    
    
    
   
    
    
            
            
    
    
}
