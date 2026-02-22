package be.nicholas.api.vehicle.web.out;

import be.nicholas.api.vehicle.domain.Vehicle;
import be.nicholas.api.vehicle.resource.out.VehicleResponseResource;
import be.nicholas.api.vehicle.service.VehicleClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleClientServiceImpl implements VehicleClientService {

    private final VehicleClient client;

    @Override
    public List<Vehicle> getVehicles() {
        log.info("get vehicles");
        return client.getVehicles().getVehicles().stream().map(this::getVehicle).collect(Collectors.toList());
    }

    private Vehicle getVehicle(VehicleResponseResource response) {
        return new Vehicle(response.getVin(), response.getName(), response.getLicensePlate(),
                response.getState(), response.getDevicePlatform(), response.getSystemModelId(), response.getTitle());
    }
}
