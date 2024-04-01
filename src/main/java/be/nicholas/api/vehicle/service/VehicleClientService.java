package be.nicholas.api.vehicle.service;

import be.nicholas.api.vehicle.domain.Vehicle;

import java.util.List;

public interface VehicleClientService {
    List<Vehicle> getVehicles();
}
