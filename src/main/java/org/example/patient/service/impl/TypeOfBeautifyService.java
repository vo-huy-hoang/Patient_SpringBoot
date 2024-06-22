package org.example.patient.service.impl;

import org.example.patient.model.TypeOfBeautify;
import org.example.patient.repository.ITypeOfBeautifyRepository;
import org.example.patient.service.ITypeOfBeautifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfBeautifyService implements ITypeOfBeautifyService {
    @Autowired
    private ITypeOfBeautifyRepository typeOfBeautifyRepository;

    @Override
    public List<TypeOfBeautify> findAll() {
        return typeOfBeautifyRepository.findAll();
    }
}
