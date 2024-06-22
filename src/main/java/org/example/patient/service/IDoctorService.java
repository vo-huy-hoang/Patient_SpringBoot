package org.example.patient.service;

import org.example.patient.model.Doctor;

import javax.print.Doc;
import java.util.List;

public interface IDoctorService {
    List<Doctor> findAll();
}
