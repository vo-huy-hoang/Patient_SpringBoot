package org.example.patient.repository;

import org.example.patient.model.ReExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IReExaminationRepository extends JpaRepository<ReExamination, Integer> {
    List<ReExamination> findByCustomer_Id(Integer id);
}
