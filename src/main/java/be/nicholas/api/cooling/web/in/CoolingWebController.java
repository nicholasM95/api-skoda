package be.nicholas.api.cooling.web.in;

import be.nicholas.api.controller.CoolingApi;
import be.nicholas.api.cooling.mapper.CoolingMapper;
import be.nicholas.api.cooling.service.CoolingService;
import be.nicholas.api.resource.CoolingWebResponseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CoolingWebController implements CoolingApi {

    private final CoolingMapper mapper;
    private final CoolingService service;

    @Override
    public ResponseEntity<CoolingWebResponseResource> getCoolingStatus(String vin) {
        return ResponseEntity.ok(mapper.toWebResource(service.getCooling(vin)));
    }
}
