package com.coworkers.clinicpet.repository;

import com.coworkers.clinicpet.model.entities.ScheduleAMedicalAppointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleAMedicalAppointmentRepository extends JpaRepository<ScheduleAMedicalAppointments, Long> {
}
