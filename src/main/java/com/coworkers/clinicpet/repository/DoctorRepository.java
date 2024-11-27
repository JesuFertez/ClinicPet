package com.coworkers.clinicpet.repository;

import com.coworkers.clinicpet.model.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
