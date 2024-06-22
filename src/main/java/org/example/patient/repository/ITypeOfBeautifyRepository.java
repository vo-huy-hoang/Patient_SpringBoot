package org.example.patient.repository;

import org.example.patient.model.TypeOfBeautify;
import org.hibernate.boot.model.internal.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITypeOfBeautifyRepository extends JpaRepository<TypeOfBeautify, Integer> {
    List<TypeOfBeautify> findAll();
}
