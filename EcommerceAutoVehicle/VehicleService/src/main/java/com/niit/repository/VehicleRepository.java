package com.niit.repository;


import com.niit.domain.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle,String> {
}
