package com.challenge.conexa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "patient")
public class Patient extends User{
    private String name;

    @Column(name="total_appointment")
    private Long totalAppointment = (long) 0;
    private String onlineStatus;

    @OneToMany(
        mappedBy = "professional",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonIgnore
    private List<Appointment> appointments;

}