package org.example.patient.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.patient.model.Customer;
import org.example.patient.model.Doctor;
import org.example.patient.model.Location;
import org.example.patient.model.TypeOfBeautify;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO implements Validator {
    private String id;
    private String code;
    private String name;
    private String birthDay;
    private String phoneNumber;
    private String dateOfReExamination;
    private Doctor doctor;
    private Location location;
    private TypeOfBeautify typeOfBeautify;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
    }
}
