package be.nicholas.api.ventilator.web.in;

import be.nicholas.api.controller.VentilatorApi;
import be.nicholas.api.resource.VentilatorWebRequestResource;
import be.nicholas.api.resource.VentilatorWebResponseResource;
import be.nicholas.api.ventilator.domain.Ventilator;
import be.nicholas.api.ventilator.mapper.VentilatorMapper;
import be.nicholas.api.ventilator.service.VentilatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@RestController
public class VentilatorWebController implements VentilatorApi {
    private final VentilatorMapper mapper;
    private final VentilatorService service;


    @Override
    public ResponseEntity<VentilatorWebResponseResource> startVentilator(String vin, VentilatorWebRequestResource ventilatorWebRequestResource) {
        Ventilator response = service.startVentilator(vin, ventilatorWebRequestResource.getPin(), ventilatorWebRequestResource.getDuration());

        UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/request/{vin}/{id}").buildAndExpand(response.vin(), response.requestId());
        return ResponseEntity.created(uriComponents.toUri()).body(mapper.toWebResource(response));
    }

    @Override
    public ResponseEntity<VentilatorWebResponseResource> stopVentilator(String vin, VentilatorWebRequestResource ventilatorWebRequestResource) {
        Ventilator response = service.stopVentilator(vin);

        UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/request/{vin}/{id}").buildAndExpand(response.vin(), response.requestId());
        return ResponseEntity.created(uriComponents.toUri()).body(mapper.toWebResource(response));
    }
}
