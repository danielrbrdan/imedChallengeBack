package com.challenge.conexa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.challenge.conexa.controller.AppointmentController;
import com.challenge.conexa.controller.UserController;
import com.challenge.conexa.model.Patient;
import com.challenge.conexa.model.Professional;
import com.challenge.conexa.repository.ProfessionalRepository;
import com.challenge.conexa.repository.UserRepository;
import com.challenge.conexa.service.PatientService;
import com.challenge.conexa.service.ProfessionalService;
import com.challenge.conexa.service.UserDetailServiceImpl;
import com.google.gson.Gson;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
public class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserRepository userRepository;
    @MockBean
    private PatientService patientService;

    @MockBean
    private ProfessionalService professionalService;
	@MockBean
    private ProfessionalRepository professionalRepository;

	@MockBean
    private AppointmentController appointmentController;
	@MockBean
	private UserDetailServiceImpl userDetailServiceImpl;

	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.userController);
	}

	@Test
	public void newProfessionalUser(){
		Professional prof = new Professional();
		prof.setLogin("ProfessionalUser");
		prof.setPassword("ProfessionalPass");
		prof.setName("Professional Name");
		prof.setCrm("10000");

		Mockito.when(this.professionalService.save(prof))
			.thenReturn(prof);

		Gson gson = new Gson();
		String jsonString = gson.toJson(prof, Professional.class);

		RestAssuredMockMvc.given()
		.body(jsonString)
			.contentType(ContentType.JSON)
		.when()
			.post("/api/user/save/professional")
		.then()
			.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void newPatientUser(){
		Patient patient = new Patient();
		patient.setLogin("PatientUser");
		patient.setPassword("PatientPass");
		patient.setName("Patient Name");

		Mockito.when(this.patientService.save(patient))
			.thenReturn(patient);

		Gson gson = new Gson();
		String jsonString = gson.toJson(patient, Patient.class);

		RestAssuredMockMvc.given()
		.body(jsonString)
			.contentType(ContentType.JSON)
		.when()
			.post("/api/user/save/patient")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
}
