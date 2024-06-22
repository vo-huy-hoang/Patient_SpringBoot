package org.example.patient.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.patient.model.ReExamination;

import java.util.List;
import java.util.Map;

public interface IReExaminationService {

    void save(ReExamination reExamination);
    void delete(Integer id);
    void validate(HttpServletRequest request, Map<String, String> massageError);
    List<ReExamination> findByCustomer_Id(Integer id);
}
