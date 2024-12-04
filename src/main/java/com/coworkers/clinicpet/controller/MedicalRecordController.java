package com.coworkers.clinicpet.controller;

import com.coworkers.clinicpet.model.dto.MedicalRecordDTO;
import com.coworkers.clinicpet.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-record")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping
    public ResponseEntity<List<MedicalRecordDTO>> getMedicalRecordAll() {
        List<MedicalRecordDTO> records = medicalRecordService.getAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordDTO> getMedicalRecordById(@PathVariable Long id) {
        MedicalRecordDTO record = medicalRecordService.getMedicalRecordById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicalRecordDTO> createRecord(@RequestBody MedicalRecordDTO medicalRecordDTO) {
        MedicalRecordDTO createdRecord = medicalRecordService.createMedicalRecord(medicalRecordDTO);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecordDTO> updateRecord(@PathVariable Long recordId, @RequestBody MedicalRecordDTO medicalRecordDTO){
        MedicalRecordDTO updateRecord = medicalRecordService.updateRecord( recordId, medicalRecordDTO);
        return ResponseEntity.ok(updateRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long recordId){
        medicalRecordService.deleteRecord( recordId);
        return ResponseEntity.noContent().build();
    }
}
