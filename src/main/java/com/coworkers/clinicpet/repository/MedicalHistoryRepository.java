package com.coworkers.clinicpet.repository;

import com.coworkers.clinicpet.model.entities.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
}
