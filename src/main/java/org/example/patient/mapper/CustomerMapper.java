package org.example.patient.mapper;

import org.example.patient.dto.ReExaminationCreateDTO;
import org.example.patient.model.Customer;
import org.example.patient.model.ReExamination;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component("customerMapper")
public interface CustomerMapper {
    Customer toCustomerFromReExaminationCreateDTO(ReExaminationCreateDTO reExaminationCreateDTO);
}
