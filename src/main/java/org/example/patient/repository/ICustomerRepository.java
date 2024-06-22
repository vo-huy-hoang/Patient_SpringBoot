package org.example.patient.repository;

import org.example.patient.model.Customer;
import org.example.patient.model.ReExamination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "from Customer as c where (:name = '' or :name is null or c.name like concat('%', :name, '%'))" +
            "and (:fromDateOfReExamination is null or c.dateOfReExamination >= :fromDateOfReExamination )" +
            "and (:toDateOfReExamination is null or c.dateOfReExamination <= :toDateOfReExamination )")
    Page<Customer> search(@Param("name") String name, @Param("fromDateOfReExamination") LocalDate fromDateOfReExamination, @Param("toDateOfReExamination") LocalDate toDateOfReExamination, Pageable pageable);


}
