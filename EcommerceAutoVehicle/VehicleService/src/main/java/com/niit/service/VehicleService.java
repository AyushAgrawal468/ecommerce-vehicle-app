package com.niit.service;

import com.niit.domain.Vehicle;
import com.niit.exceptions.VehicleAlreadyPresentException;

import java.util.List;

public interface VehicleService {
    Vehicle saveVehicleDetails(Vehicle vehicle) throws VehicleAlreadyPresentException;
    List<Vehicle> getAllVehicleDetails() throws Exception;
}
