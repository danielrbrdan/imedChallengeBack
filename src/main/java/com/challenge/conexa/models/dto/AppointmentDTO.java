package com.challenge.conexa.models.dto;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private Long id;
    private Long professionalId;
    private String time;
    private String date;
    
    private ZonedDateTime date_created;
    private PatientDTO patient;
    private ProfessionalDTO professional;
}
