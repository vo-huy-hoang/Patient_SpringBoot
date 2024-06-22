package org.example.patient.service;

import org.example.patient.dto.CustomerSearchDTO;
import org.example.patient.model.Customer;
import org.example.patient.model.ReExamination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Customer findById(Integer id);
    Page<Customer> search(CustomerSearchDTO customerSearchDTO, Pageable pageable);

    void delete(Customer customer);

    void deleteById(Integer id);
    List<Customer> findAll();
}
