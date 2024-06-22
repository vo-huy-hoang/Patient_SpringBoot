package org.example.patient.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.example.patient.model.ReExamination;
import org.example.patient.repository.ICustomerRepository;
import org.example.patient.repository.IDoctorRepository;
import org.example.patient.repository.ILocationRepository;
import org.example.patient.repository.IReExaminationRepository;
import org.example.patient.service.IReExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReExaminationService implements IReExaminationService {
    @Autowired
    private IReExaminationRepository reExaminationRepository;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IDoctorRepository doctorRepository;
    @Autowired
    private ILocationRepository locationRepository;

    @Override
    public void save(ReExamination reExamination) {
        reExamination.setCustomer(customerRepository.findById(reExamination.getCustomer().getId()).get());
        reExamination.setDoctor(doctorRepository.findById(reExamination.getDoctor().getId()).get());
        reExamination.setLocation(locationRepository.findById(reExamination.getLocation().getId()).get());
        reExaminationRepository.save(reExamination);
    }

    @Override
    public List<ReExamination> findByCustomer_Id(Integer id) {
        return reExaminationRepository.findByCustomer_Id(id);
    }

    @Override
    public void delete(Integer id) {
        reExaminationRepository.deleteById(id);
    }


    @Override
    public void validate(HttpServletRequest request, Map<String, String> massageError) {
        String contentStr= request.getParameter("content");
        String dateOfReExaminationStr = request.getParameter("dateOfReExamination");
        if (contentStr.trim().equals("")) {
            massageError.put("content", "Nội dung bắt buộc nhập");
        }
        if (dateOfReExaminationStr.trim().equals("")) {
            massageError.put("dateOfReExaminationStr", "Ngày bắt buộc nhập bắt buộc nhập");
        }
    }
}
