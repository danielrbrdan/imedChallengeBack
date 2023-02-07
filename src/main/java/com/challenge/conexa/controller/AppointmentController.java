package com.challenge.conexa.controller;

import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conexa.models.dto.AppointmentDTO;
import com.challenge.conexa.service.AppointmentService;
import com.challenge.conexa.utils.Mapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final Mapper mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<AppointmentDTO>> findAllByProfessionalId(@PathVariable Long id) {
        List<AppointmentDTO> appointmentsDTO = 
            this.mapper.mapList(appointmentService.findAllByProfessionalId(id), AppointmentDTO.class);

        return ResponseEntity.ok().body(appointmentsDTO);
    }

    @GetMapping(value = "/{id}/{date}")
    public ResponseEntity<List<AppointmentDTO>> findAllByProfessionalIdAndDate(@PathVariable Long id, @PathVariable String date) throws ParseException {
        List<AppointmentDTO> appointmentsDTO = 
            this.mapper.mapList(appointmentService.findAllByProfessionalIdAndDate(id, date), AppointmentDTO.class);

        return ResponseEntity.ok().body(appointmentsDTO);
    }

    @GetMapping()
    public ResponseEntity<List<AppointmentDTO>> findAll() {
        List<AppointmentDTO> appointmentsDTO = 
            this.mapper.mapList(appointmentService.findAll(), AppointmentDTO.class);
        
        return ResponseEntity.ok().body(appointmentsDTO);
    }
    @GetMapping(value = "/professional-appointments")
    public ResponseEntity<List<AppointmentDTO>> findAllProfessionalAppointments() {
        List<AppointmentDTO> appointmentsDTO = 
            this.mapper.mapList(appointmentService.findAllProfessionalAppointments(), AppointmentDTO.class);

        return ResponseEntity.ok().body(appointmentsDTO);
    }

    @PostMapping()
    public ResponseEntity<AppointmentDTO> save(@RequestBody AppointmentDTO appointmentDTO) throws Exception {
        AppointmentDTO appointDTO = mapper.map(
            appointmentService.save(appointmentDTO), AppointmentDTO.class);

        return ResponseEntity.ok(appointDTO);
    }
   
    @Transactional
    @PostMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        appointmentService.deleteById(id);
    }
}
