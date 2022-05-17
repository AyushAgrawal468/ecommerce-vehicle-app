package com.niit.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vehicle {
    @Id
    private String vehicleId;
    private String vehicleType;
    private String vehicleModel;
    private String vehicleManufDate;

    public Vehicle() {
    }

    public Vehicle(String vehicleId, String vehicleType, String vehicleModel, String vehicleManufDate) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.vehicleManufDate = vehicleManufDate;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleManufDate() {
        return vehicleManufDate;
    }

    public void setVehicleManufDate(String vehicleManufDate) {
        this.vehicleManufDate = vehicleManufDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleManufDate='" + vehicleManufDate + '\'' +
                '}';
    }
}
