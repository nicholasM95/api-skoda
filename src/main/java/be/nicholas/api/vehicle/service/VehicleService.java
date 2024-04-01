package be.nicholas.api.vehicle.service;

import be.nicholas.api.vehicle.domain.Vehicle;
import be.nicholas.api.vehicle.resource.out.VehicleResponseResource;
import be.nicholas.api.vehicle.web.out.VehicleClient;
import be.nicholas.api.vehicle.web.out.VehicleClientServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleService {

    private final VehicleClientService service;

    public List<Vehicle> findAllVehicles() {
        log.info("find all vehicles");
        return service.getVehicles();
    }
}
