package com.coworkers.clinicpet.service;

import com.coworkers.clinicpet.model.entities.Doctor;
import com.coworkers.clinicpet.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorService {
    private DoctorRepository doctorRepository;

//    public Doctor getDoctorById(Long id) throws RuntimeException{
//
//    }
}
