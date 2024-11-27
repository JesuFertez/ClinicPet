package com.coworkers.clinicpet.repository;

import com.coworkers.clinicpet.model.entities.MedicalAttention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalAttentionRepository extends JpaRepository<MedicalAttention, Long> {
}
