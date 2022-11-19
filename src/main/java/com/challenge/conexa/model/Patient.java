package com.challenge.conexa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "patient")
public class Patient extends User{
    private String name;

    @Column(name="total_appointment")
    private Long totalAppointment;
    private String onlineStatus;

    @OneToMany(
        mappedBy = "professional",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonIgnore
    private List<Appointment> appointments;



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Long getTotalAppointment() {
        return totalAppointment;
    }


    public void setTotalAppointment(Long totalAppointment) {
        this.totalAppointment = totalAppointment;
    }


    public String getOnlineStatus() {
        return onlineStatus;
    }


    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }


    public List<Appointment> getAppointments() {
        return appointments;
    }


    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    

    
}