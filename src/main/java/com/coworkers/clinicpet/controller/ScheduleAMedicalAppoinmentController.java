package com.coworkers.clinicpet.controller;

import com.coworkers.clinicpet.model.dto.ScheduleAMedicalAppointmentsDTO;
import com.coworkers.clinicpet.service.ScheduleAMedicalAppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule_Medicals")
public class ScheduleAMedicalAppoinmentController {

    @Autowired
    private ScheduleAMedicalAppointmentsService scheduleAMedicalService;

  @PostMapping
    public ResponseEntity<ScheduleAMedicalAppointmentsDTO> createScheduleMedical(
            @RequestBody ScheduleAMedicalAppointmentsDTO schedulemedicalDTO) {
      var createdScheduleMedical = scheduleAMedicalService.createScheduleMedical(schedulemedicalDTO);
      return  new ResponseEntity<>(createdScheduleMedical, HttpStatus.CREATED);
  }

  @GetMapping
    public ResponseEntity<List<ScheduleAMedicalAppointmentsDTO>> getAllScheduleMedicalAppointments() {
      List<ScheduleAMedicalAppointmentsDTO> schedulesMedicals = scheduleAMedicalService.getAllScheduleMedical();
      return new ResponseEntity<>(schedulesMedicals, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ScheduleAMedicalAppointmentsDTO> getScheduleMedicalById(@PathVariable("id") Long id) {
    var scheduleMedical = scheduleAMedicalService.getScheduleMedicalById(id);
    return new ResponseEntity<>(scheduleMedical, HttpStatus.OK);
  }
}
