package com.coworkers.clinicpet.repository;

import com.coworkers.clinicpet.model.entities.MedicalAttention;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalAttentionRepository extends JpaRepository<MedicalAttention, Long> {
    List<MedicalAttention> findByAppointment_Id(Long appointmentId);
}
