package com.coworkers.clinicpet.service;

import com.coworkers.clinicpet.model.dto.ScheduleAMedicalAppointmentsDTO;
import com.coworkers.clinicpet.model.entities.Doctor;
import com.coworkers.clinicpet.model.entities.MedicalAttention;
import com.coworkers.clinicpet.model.entities.Pet;
import com.coworkers.clinicpet.model.entities.ScheduleAMedicalAppointments;
import com.coworkers.clinicpet.repository.ScheduleAMedicalAppointmentRepository;
import com.coworkers.clinicpet.util.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleAMedicalAppointmentsService {

    @Autowired
    private ScheduleAMedicalAppointmentRepository scheduleMedicalRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ScheduleAMedicalAppointmentsDTO createScheduleMedical(ScheduleAMedicalAppointmentsDTO scheduleMedicalDTO) {
        ScheduleAMedicalAppointments scheduleMedical = modelMapper.map(scheduleMedicalDTO, ScheduleAMedicalAppointments.class);
        ScheduleAMedicalAppointments newScheduleMedical = scheduleMedicalRepository.save(scheduleMedical);
        return modelMapper.map(newScheduleMedical, ScheduleAMedicalAppointmentsDTO.class);
    }

    public List<ScheduleAMedicalAppointmentsDTO> getAllScheduleMedical() {
        List<ScheduleAMedicalAppointments> scheduleMedicals = scheduleMedicalRepository.findAll();
        return scheduleMedicals.stream()
                .map(scheduleMedical -> modelMapper.map(scheduleMedicals, ScheduleAMedicalAppointmentsDTO.class))
                .collect(Collectors.toList());
    }

    public ScheduleAMedicalAppointmentsDTO getScheduleMedicalById(Long id) {
        ScheduleAMedicalAppointments scheduleMedical = scheduleMedicalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Schedule Medical Not Found" + id));
        return modelMapper.map(scheduleMedical, ScheduleAMedicalAppointmentsDTO.class);
    }

    public ScheduleAMedicalAppointmentsDTO updateScheduleMedical(ScheduleAMedicalAppointmentsDTO scheduleMedicalDTO, Long id) {
        ScheduleAMedicalAppointments existingMedicalAppoinment = scheduleMedicalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Schedule Medical Not Found" + id));

        existingMedicalAppoinment.setDate(scheduleMedicalDTO.getDate());
        existingMedicalAppoinment.setTypeOfAppointment(scheduleMedicalDTO.getTypeOfAppoinment());
        existingMedicalAppoinment.setDoctor(modelMapper.map(scheduleMedicalDTO.getDoctorDTO(), Doctor.class));
        existingMedicalAppoinment.setPatient(modelMapper.map(scheduleMedicalDTO.getPatient(), Pet.class));
        existingMedicalAppoinment.setMedicalAttention(modelMapper.map(scheduleMedicalDTO.getMedicalAttentionDTO(), MedicalAttention.class));
        ScheduleAMedicalAppointments newScheduleMedical = scheduleMedicalRepository.save(existingMedicalAppoinment);
        return modelMapper.map(newScheduleMedical, ScheduleAMedicalAppointmentsDTO.class);
    }

    public void deleteScheduleMedicalById(Long id) {
        ScheduleAMedicalAppointments ScheduleMedical = scheduleMedicalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Schedule Medical Not Found" + id));
        scheduleMedicalRepository.delete(ScheduleMedical);
    }
}
