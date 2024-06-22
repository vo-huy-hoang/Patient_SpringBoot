package org.example.patient.service.impl;

import org.example.patient.dto.CustomerSearchDTO;
import org.example.patient.model.Customer;
import org.example.patient.model.ReExamination;
import org.example.patient.repository.ICustomerRepository;
import org.example.patient.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public Page<Customer> search(CustomerSearchDTO customerSearchDTO, Pageable pageable) {
        return customerRepository.search(customerSearchDTO.getName(),
                customerSearchDTO.getFromDateOfReExamination() == null || customerSearchDTO.getFromDateOfReExamination().isEmpty() ? null : LocalDate.parse(customerSearchDTO.getFromDateOfReExamination()),
                customerSearchDTO.getToDateOfReExamination() == null || customerSearchDTO.getToDateOfReExamination().isEmpty() ? null : LocalDate.parse(customerSearchDTO.getToDateOfReExamination()), pageable);
    }


    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
