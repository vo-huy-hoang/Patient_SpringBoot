package org.example.patient.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "birth_day")
    private LocalDate birthDay;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_re_examination")
    private LocalDate dateOfReExamination;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "type_of_beautify_id")
    private TypeOfBeautify typeOfBeautify;
//    @OneToMany(mappedBy = "customer")
//    private Set<ReExamination> reExaminationSet;

}
