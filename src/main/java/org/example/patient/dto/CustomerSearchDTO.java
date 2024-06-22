package org.example.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSearchDTO {
    private String name;
    private String fromDateOfReExamination;
    private String toDateOfReExamination;
}
