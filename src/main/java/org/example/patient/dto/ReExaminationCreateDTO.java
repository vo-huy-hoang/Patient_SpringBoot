package org.example.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.patient.model.Customer;
import org.example.patient.model.Doctor;
import org.example.patient.model.Location;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReExaminationCreateDTO implements Validator {
    private Location location;
    private Customer customer;
    private Doctor doctor;
    private String dateOfReExamination;
    private String content;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ReExaminationCreateDTO reExaminationCreateDTO = (ReExaminationCreateDTO) target;
    }
}
