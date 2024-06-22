package org.example.patient.service.impl;

import org.example.patient.model.Location;
import org.example.patient.repository.ILocationRepository;
import org.example.patient.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService {
    @Autowired
    private ILocationRepository locationRepository;
    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }
}
