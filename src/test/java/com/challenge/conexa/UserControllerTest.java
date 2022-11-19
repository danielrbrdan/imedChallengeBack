package com.challenge.conexa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.challenge.conexa.controller.UserController;
import com.challenge.conexa.model.Patient;
import com.challenge.conexa.model.PatientDTO;
import com.challenge.conexa.model.Professional;
import com.challenge.conexa.model.ProfessionalDTO;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public class UserControllerTest {
    @Autowired
    private UserController userController;

    /* 
    @Test
    public void saveProfessional(){
        Professional professional = new Professional();
        professional.setName("Test Professional Name");
        professional.setCrm("99999");
        professional.setLogin("testLoginProfessional");
        professional.setPassword("testProfessionalPassword");
        ProfessionalDTO createdProfessional = userController.save(professional).getBody();
        if(createdProfessional != null){
            assertEquals(professional.getName(), createdProfessional.getName());
        }
    }

    @Test
    public void savePatient(){
        Patient patient = new Patient();
        patient.setName("Test Patient Name");
        patient.setLogin("testLoginPatient");
        patient.setPassword("testPatientPassword");
        PatientDTO createdPatient = userController.save(patient).getBody();
        if(createdPatient != null){
            assertEquals(patient, createdPatient);
        }
    }
    */
}
