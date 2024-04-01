package be.nicholas.api.vehicle.mapper;

import be.nicholas.api.resource.VehicleWebResponseResource;
import be.nicholas.api.vehicle.domain.Vehicle;

import java.util.List;

public interface VehicleMapper {
    VehicleWebResponseResource toWebResource(final Vehicle vehicle);

    List<VehicleWebResponseResource> toWebResource(final List<Vehicle> vehicles);
}
