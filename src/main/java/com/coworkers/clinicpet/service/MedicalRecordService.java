package com.coworkers.clinicpet.service;

import com.coworkers.clinicpet.model.dto.MedicalRecordDTO;
import com.coworkers.clinicpet.model.entities.MedicalRecord;
import com.coworkers.clinicpet.repository.MedicalRecordRepository;
import com.coworkers.clinicpet.util.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    @Autowired
    private ModelMapper modelMapper;

    public MedicalRecordDTO createMedicalRecord(MedicalRecordDTO dto) {
        MedicalRecord record = modelMapper.map(dto, MedicalRecord.class);
        record = medicalRecordRepository.save(record);
        return modelMapper.map(record, MedicalRecordDTO.class);
    }

    public List<MedicalRecordDTO> getAllRecords() {
        List<MedicalRecord> records = medicalRecordRepository.findAll();
        return records.stream().map(record -> modelMapper
                .map(record, MedicalRecordDTO.class))
                .toList();
    }

    public MedicalRecordDTO getMedicalRecordById(Long recordId) {
        MedicalRecord record = medicalRecordRepository.findById(recordId).orElseThrow(() -> new NotFoundException("Medical Record not found for ID: " + recordId));
        return modelMapper.map(record, MedicalRecordDTO.class);
    }


    public MedicalRecordDTO updateRecord(Long recordId, MedicalRecordDTO dto) {
        MedicalRecord record = medicalRecordRepository.findById(recordId)
                .orElseThrow(() -> new NotFoundException("Record no found"));
        record.setState(dto.getState());
        record.setVaccines(dto.getVaccines());
        record.setWeight(dto.getWeight());
        medicalRecordRepository.save(record);
        return modelMapper.map(record, MedicalRecordDTO.class);
    }
}
