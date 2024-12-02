package com.coworkers.clinicpet.service;

import com.coworkers.clinicpet.model.dto.MedicalHistoryDTO;
import com.coworkers.clinicpet.model.entities.MedicalHistory;
import com.coworkers.clinicpet.model.entities.ScheduleAMedicalAppointments;
import com.coworkers.clinicpet.repository.MedicalHistoryRepository;
import com.coworkers.clinicpet.repository.ScheduleAMedicalAppointmentRepository;
import com.coworkers.clinicpet.util.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    private ScheduleAMedicalAppointmentRepository scheduleAMedicalAppoinmentRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<MedicalHistoryDTO> getAllHistories() {
        List<MedicalHistory> histories = medicalHistoryRepository.findAll();
        return histories.stream().map(history -> modelMapper.map(history, MedicalHistoryDTO.class))
                .toList();
    }

    public MedicalHistoryDTO getHistoryById(Long id){

        MedicalHistory history = medicalHistoryRepository.findById(id).orElseThrow(()-> new NotFoundException("History not found"));
        return modelMapper.map(history,MedicalHistoryDTO.class);
    }

    public MedicalHistoryDTO addAppointmentToHistory(Long historyId, Long appointmentId) {
        // BUSCO HISTORIAL
        MedicalHistory history = medicalHistoryRepository.findById(historyId)
                .orElseThrow(() -> new NotFoundException("History not found"));

        //busco cita
        ScheduleAMedicalAppointments appointment = scheduleAMedicalAppoinmentRepository.findById(appointmentId)
                .orElseThrow(() -> new NotFoundException("Appointment not found"));

        if (history.getScheduleAMedicalAppointments() == null) {
            history.setScheduleAMedicalAppointments(new ArrayList<>());
        }
//agrego la cita
        history.getScheduleAMedicalAppointments().add(appointment);

        //guardo el historial
        medicalHistoryRepository.save(history);

//        retorno el historial dto ˘
        return modelMapper.map(history, MedicalHistoryDTO.class);
    }

    public MedicalHistoryDTO createdHistory(MedicalHistoryDTO medicalHistoryDTO) {
        MedicalHistory history = modelMapper.map(medicalHistoryDTO, MedicalHistory.class);

        MedicalHistory savedHistory = medicalHistoryRepository.save(history);
        return modelMapper.map(savedHistory, MedicalHistoryDTO.class);
    }
}
