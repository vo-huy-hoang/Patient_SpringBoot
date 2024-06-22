package org.example.patient.mapper;

import org.example.patient.dto.ReExaminationCreateDTO;
import org.example.patient.model.ReExamination;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component("reExaminationMapper")
public interface ReExaminationMapper {
    ReExamination toReExaminationFromReExaminationCreateDTO(ReExaminationCreateDTO reExaminationCreateDTO);
}
