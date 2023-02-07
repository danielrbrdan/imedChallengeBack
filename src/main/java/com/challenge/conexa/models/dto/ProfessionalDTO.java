package com.challenge.conexa.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalDTO  extends UserDTO{
    private String name;
    private String crm;

    private String status;
    private String rating;
}
