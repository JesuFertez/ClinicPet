package com.coworkers.clinicpet.repository;

import com.coworkers.clinicpet.model.entities.ScheduleAMedicalAppoinments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleAMedicalAppoinmentRepository extends JpaRepository<ScheduleAMedicalAppoinments, Long> {
}