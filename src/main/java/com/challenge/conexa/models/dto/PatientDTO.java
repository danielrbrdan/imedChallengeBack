package com.challenge.conexa.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO extends UserDTO{
    private String name;

    private Long totalAppointment;
    private String onlineStatus;

}
