package com.coworkers.clinicpet.service;

import com.coworkers.clinicpet.model.dto.DoctorDTO;
import com.coworkers.clinicpet.model.entities.Doctor;
import com.coworkers.clinicpet.repository.DoctorRepository;
import com.coworkers.clinicpet.util.NotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;
    @Autowired
    private ModelMapper modelMapper;

    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor= modelMapper.map(doctorDTO, Doctor.class);
        Doctor newDoctor = doctorRepository.save(doctor);
        return modelMapper.map(newDoctor, DoctorDTO.class);
    }

    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
    }

    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found"+id));
        return modelMapper.map(doctor, DoctorDTO.class);
    }

    public DoctorDTO updateDoctor(DoctorDTO doctorDTO, Long id) {
        Doctor doctorExisting = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found"+id));

        doctorExisting.setName(doctorDTO.getName());
        doctorExisting.setLastName(doctorDTO.getLastName());
        doctorExisting.setSpecialty(doctorDTO.getSpecialty());
        Doctor newDoctor = doctorRepository.save(doctorExisting);
        return modelMapper.map(newDoctor, DoctorDTO.class);
    }

    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found"+id));
        doctorRepository.delete(doctor);
    }
}
