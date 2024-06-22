package org.example.patient.repository;

import org.example.patient.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
//    @Query(value = "select d.id, d.code from Doctor as d")
//    List<Doctor> findAll(@Param("id") Integer id, @Param("code") String code);
}
