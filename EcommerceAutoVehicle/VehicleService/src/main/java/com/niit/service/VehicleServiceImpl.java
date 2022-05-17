package com.niit.service;

import com.niit.domain.Vehicle;
import com.niit.exceptions.VehicleAlreadyPresentException;
import com.niit.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{
    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle saveVehicleDetails(Vehicle vehicle) throws VehicleAlreadyPresentException {
        //for save and update- same method
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicleDetails() throws Exception {
        return vehicleRepository.findAll();
    }
}
