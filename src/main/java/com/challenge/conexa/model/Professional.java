package com.challenge.conexa.model;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "professional")
public class Professional extends User{
    private ZonedDateTime date_created;
    
    private String name;
    private String crm;
    private String status;
    private String rating;

    @OneToMany(
        mappedBy = "professional",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Appointment> appointments;

    @OneToMany(
        mappedBy = "professional",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Insurance> insurances;

    public void setDate_created(ZonedDateTime date_created) {
        this.date_created = date_created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    
}