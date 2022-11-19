package com.challenge.conexa.model;

import java.util.Calendar;

import lombok.Getter;

public class AppointmentDTO {
    private Long id;
    private Long professionalId;
    private String time;
    private String date;

    public Long getProfessionalId() {
        return professionalId;
    }
    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
}
