package be.nicholas.api.vehicle.web.in;

import be.nicholas.api.controller.VehicleApi;
import be.nicholas.api.resource.VehicleWebResponseResource;
import be.nicholas.api.vehicle.mapper.VehicleMapper;
import be.nicholas.api.vehicle.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VehicleWebController implements VehicleApi {

    private final VehicleMapper mapper;
    private final VehicleService service;

    @Override
    public ResponseEntity<List<VehicleWebResponseResource>> findAllVehicles() {
        return ResponseEntity.ok(mapper.toWebResource(service.findAllVehicles()));
    }
}
