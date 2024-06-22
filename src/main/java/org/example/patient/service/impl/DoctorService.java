package org.example.patient.service.impl;

import org.example.patient.model.Doctor;
import org.example.patient.repository.IDoctorRepository;
import org.example.patient.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {
    @Autowired
    private IDoctorRepository dotorRepository;
    @Override
    public List<Doctor> findAll() {
        return dotorRepository.findAll();
    }
}
