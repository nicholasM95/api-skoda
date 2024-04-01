package be.nicholas.api.vehicle.mapper;

import be.nicholas.api.resource.VehicleWebResponseResource;
import be.nicholas.api.vehicle.domain.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleMapperImpl implements VehicleMapper {
    @Override
    public VehicleWebResponseResource toWebResource(final Vehicle vehicle) {
        return VehicleWebResponseResource.builder()
                .id(vehicle.id())
                .vin(vehicle.vin())
                .name(vehicle.name())
                .lastUpdated(vehicle.lastUpdated())
                .build();
    }

    @Override
    public List<VehicleWebResponseResource> toWebResource(final List<Vehicle> vehicles) {
        return vehicles.stream().map(this::toWebResource).collect(Collectors.toList());
    }
}
