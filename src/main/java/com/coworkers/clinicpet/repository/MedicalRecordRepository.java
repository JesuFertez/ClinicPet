package com.coworkers.clinicpet.repository;

import com.coworkers.clinicpet.model.entities.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}
