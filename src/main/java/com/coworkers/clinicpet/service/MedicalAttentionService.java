package com.coworkers.clinicpet.service;

import com.coworkers.clinicpet.model.dto.DoctorDTO;
import com.coworkers.clinicpet.model.dto.MedicalAttentionDTO;
import com.coworkers.clinicpet.model.entities.MedicalAttention;
import com.coworkers.clinicpet.repository.MedicalAttentionRepository;
import com.coworkers.clinicpet.util.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalAttentionService {

    @Autowired
    private MedicalAttentionRepository medicalAttentionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MedicalAttentionDTO createAttention(MedicalAttentionDTO dto) {
        MedicalAttention attention = modelMapper.map(dto, MedicalAttention.class);
        return modelMapper.map(medicalAttentionRepository.save(attention), MedicalAttentionDTO.class);
    }

    public List<MedicalAttentionDTO> getAllAttentions() {
        List<MedicalAttention> attentions = medicalAttentionRepository.findAll();
        return attentions.stream()
                .map(att -> modelMapper.map(att, MedicalAttentionDTO.class))
                .collect(Collectors.toList());
    }

    public List<MedicalAttentionDTO> getAttentionsByAppointment(Long appointmentId) {
        List<MedicalAttention> attentions = medicalAttentionRepository.findByAppointment_Id(appointmentId);
        return attentions.stream()
                .map(att -> modelMapper.map(att, MedicalAttentionDTO.class))
                .collect(Collectors.toList());
    }

    public MedicalAttentionDTO updateAttention(MedicalAttentionDTO medicalAttentionDTO, Long id) {
        MedicalAttention medicalAttention = medicalAttentionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Attention not found"));

        medicalAttention.setObservations(medicalAttentionDTO.getObservations());
        medicalAttention.setNotes(medicalAttentionDTO.getNotes());
        medicalAttention.setTreatments(medicalAttentionDTO.getTreatments());

        medicalAttention = medicalAttentionRepository.save(medicalAttention);

        return modelMapper.map(medicalAttention, MedicalAttentionDTO.class);
    }

    public void deleteAttention(Long id){
        MedicalAttention medicalAttention = medicalAttentionRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Attention not found: " +id));
        medicalAttentionRepository.delete(medicalAttention);
    }
}
