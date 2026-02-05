/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petcare_sheduler;

import java.time.LocalDate;

/**
 *
 * @author danuja
 */
public class Appoinment {
    
    private String Appointment_type;
    private LocalDate Date_Time;
    private String Notes;
    
    Appoinment(String type,String Notes,LocalDate Date_Time){
        this.Appointment_type = type;
        this.Notes = Notes;
    }

    public String getAppointment_type() {
        return Appointment_type;
    }

    public void setAppointment_type(String Appointment_type) {
        this.Appointment_type = Appointment_type;
    }

    public LocalDate getDate_Time() {
        return Date_Time;
    }

    public void setDate_Time(LocalDate Date_Time) {
        this.Date_Time = Date_Time;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }
    
    
    
    
    
}
