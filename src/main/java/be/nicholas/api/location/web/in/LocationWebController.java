package be.nicholas.api.location.web.in;

import be.nicholas.api.controller.LocationApi;
import be.nicholas.api.location.mapper.LocationMapper;
import be.nicholas.api.location.service.LocationService;
import be.nicholas.api.resource.LocationWebResponseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LocationWebController implements LocationApi {

    private final LocationMapper mapper;
    private final LocationService service;

    @Override
    public ResponseEntity<LocationWebResponseResource> getLocation(String vin) {
        return ResponseEntity.ok(mapper.toWebResource(service.findLocationByVin(vin)));
    }
}
