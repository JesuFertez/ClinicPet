package com.coworkers.clinicpet.service;

import com.coworkers.clinicpet.model.dto.MedicalHistoryDTO;
import com.coworkers.clinicpet.model.entities.MedicalHistory;
import com.coworkers.clinicpet.model.entities.ScheduleAMedicalAppoinments;
import com.coworkers.clinicpet.repository.MedicalHistoryRepository;
import com.coworkers.clinicpet.repository.ScheduleAMedicalAppoinmentRepository;
import com.coworkers.clinicpet.util.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    private ScheduleAMedicalAppoinmentRepository scheduleAMedicalAppoinmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MedicalHistoryDTO addAppointmentToHistory(Long historyId, Long appointmentId) {
        // BUSCO HISTORIAL
        MedicalHistory history = medicalHistoryRepository.findById(historyId)
                .orElseThrow(() -> new NotFoundException("History not found"));

        //busco cita
        ScheduleAMedicalAppoinments appointment = scheduleAMedicalAppoinmentRepository.findById(appointmentId)
                .orElseThrow(() -> new NotFoundException("Appointment not found"));

        if (history.getScheduleAMedicalAppoinments() == null) {
            history.setScheduleAMedicalAppoinments(new ArrayList<>());
        }


//agrego la cita
        history.getScheduleAMedicalAppoinments().add(appointment);

        //guardo el historial
        medicalHistoryRepository.save(history);

//        retorno el historial dto ˘
        return modelMapper.map(history, MedicalHistoryDTO.class);
    }
}
