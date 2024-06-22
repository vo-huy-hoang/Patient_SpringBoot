package org.example.patient.service;

import org.example.patient.model.Location;

import java.util.List;

public interface ILocationService {
    List<Location> findAll();
}
