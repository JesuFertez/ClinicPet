package com.coworkers.clinicpet.controller;


import com.coworkers.clinicpet.model.dto.MedicalHistoryDTO;
import com.coworkers.clinicpet.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medical-history")
public class MedicalHistoryController {

    @Autowired
    private MedicalHistoryService medicalHistoryService;

//    @PostMapping("/{historyId}/appointments/{appointmentId}")
//    public ResponseEntity<MedicalHistoryDTO> addAppointmentToHistory(
//            @PathVariable Long appointmentId,
//            @PathVariable Long historyId
//    ) {
//        MedicalHistoryDTO updateHistory = medicalHistoryService.addAppointmentToHistory(historyId, appointmentId);
//        return new ResponseEntity<>(updateHistory, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<MedicalHistoryDTO> createHistory(@RequestBody MedicalHistoryDTO medicalHistoryDTO) {
        MedicalHistoryDTO createdHistory = medicalHistoryService.createdHistory(medicalHistoryDTO);
        return new ResponseEntity<>(createdHistory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicalHistoryDTO>> getAllHistories() {
        List<MedicalHistoryDTO> histories = medicalHistoryService.getAllHistories();
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalHistoryDTO> getHistoryById(@PathVariable Long id) {
        MedicalHistoryDTO history = medicalHistoryService.getHistoryById(id);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

}
