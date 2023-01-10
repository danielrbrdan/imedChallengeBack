package com.challenge.conexa.model;

import lombok.Data;

@Data
public class AppointmentDTO {
    private Long id;
    private Long professionalId;
    private String time;
    private String date;
    
}
