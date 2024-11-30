package com.coworkers.clinicpet.controller;

import com.coworkers.clinicpet.model.dto.MedicalAttentionDTO;
import com.coworkers.clinicpet.service.MedicalAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medical-attention")
public class MedicalAttentionController {

    @Autowired
    private MedicalAttentionService medicalAttentionService;

    @PostMapping
    public ResponseEntity<MedicalAttentionDTO> createAttention(@RequestBody MedicalAttentionDTO medicalAttentionDTO) {
        MedicalAttentionDTO createdAttention = medicalAttentionService.createAttention(medicalAttentionDTO);
        return new ResponseEntity<>(createdAttention, HttpStatus.CREATED);
    }

    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<List<MedicalAttentionDTO>> getAttentionsByAppointment(@PathVariable Long appointmentId){
        List<MedicalAttentionDTO> atttentions = medicalAttentionService.getAttentionsByAppointment(appointmentId);
        return  new ResponseEntity<>(atttentions, HttpStatus.OK);
    }

    @GetMapping("/appointment")
    public ResponseEntity<List<MedicalAttentionDTO>> getAllAttentions(){
        List<MedicalAttentionDTO> attentions = medicalAttentionService.getAllAttentions();
        return new ResponseEntity<>(attentions, HttpStatus.OK);
    }
}
