package com.challenge.conexa.model;

import java.util.Calendar;

import lombok.Getter;

public class AppointmentDTO {
    Integer professionalId;
    String time;
    String date;

    public Integer getProfessionalId() {
        return professionalId;
    }
    public void setProfessionalId(Integer professionalId) {
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

    
}
