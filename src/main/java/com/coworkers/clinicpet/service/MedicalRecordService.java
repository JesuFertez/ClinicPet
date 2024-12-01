package com.coworkers.clinicpet.service;

import com.coworkers.clinicpet.model.dto.MedicalRecordDTO;
import com.coworkers.clinicpet.model.entities.MedicalRecord;
import com.coworkers.clinicpet.repository.MedicalRecordRepository;
import com.coworkers.clinicpet.util.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public MedicalRecordDTO updateRecord(Long recordId, MedicalRecordDTO dto){
        MedicalRecord record = repository.findById(recordId)
                .orElseThrow(() -> new NotFoundException("Record no found"));
        record.setState(dto.getState());
        record.setVaccines(dto.getVaccines());
        record.setWeight(dto.getWeigth());
        repository.save(record);
        return modelMapper.map(record, MedicalRecordDTO.class);
    }
}
