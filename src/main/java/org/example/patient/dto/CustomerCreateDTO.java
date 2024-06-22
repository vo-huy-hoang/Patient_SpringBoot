package org.example.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreateDTO {
    private String locationId;
    private String customerId;
    private String doctorId;
    private LocalDate dateOfReExamination;
    private String typeOfBeautify;
    private String content;
}
