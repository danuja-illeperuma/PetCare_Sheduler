/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petcare_sheduler;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author danuja
 */
public class Appoinment implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String Appointment_type;
    private LocalDate Date_Time;
    private String Notes;
    private boolean done;
     enum EventStatus { UPCOMING, DUE_TODAY, OVERDUE, DONE };
    public EventStatus status;
     private final String id; //unique id
    
    Appoinment(String type,String Notes,LocalDate Date_Time){
        this.Appointment_type = type;
        this.Notes = Notes;
        this.Date_Time = Date_Time;
        this.done = false;
        this.id = UUID.randomUUID().toString();
    }
    
    public String getshortUUID(){
        return id.substring(0, 8);
        
    }
    
     public String getUUID(){
        return id;
        
    }
     public void MarkDone(){
         this.done = true;
         
         
        
         
     }
    public EventStatus SetEvent_Status(){
        
        if(done == true){
            return status.DONE;
        }
        
        LocalDate today = LocalDate.now();
        if(Date_Time.isAfter(today)){
            return status.UPCOMING;
        }
        
        if(Date_Time.isEqual(today)){
            return status.DUE_TODAY;
        }
        return status.OVERDUE;
        
        
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
