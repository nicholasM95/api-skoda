package be.nicholas.api.charging.web.in;

import be.nicholas.api.charging.domain.ChargingSession;
import be.nicholas.api.charging.domain.ChargingState;
import be.nicholas.api.charging.mapper.ChargingMapper;
import be.nicholas.api.charging.service.ChargingService;
import be.nicholas.api.controller.ChargingApi;
import be.nicholas.api.resource.ChargingSessionWebResponseResource;
import be.nicholas.api.resource.ChargingStatusWebResponseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ChargingWebController implements ChargingApi {

    private final ChargingMapper mapper;
    private final ChargingService service;

    @Override
    public ResponseEntity<List<ChargingSessionWebResponseResource>> getChargingSession(String vin) {
        List<ChargingSession> sessions = service.findAllChargingSessionsByVin(vin);
        return ResponseEntity.ok(sessions.stream()
                .map(mapper::toWebResponseResource)
                .toList());
    }

    @Override
    public ResponseEntity<ChargingStatusWebResponseResource> getChargingStatus(String vin) {
        ChargingState chargingState = service.findChargingStateByVin(vin);
        return ResponseEntity.ok(mapper.toWebResponseResource(chargingState));
    }

    @Override
    public ResponseEntity<Void> startCharging(String vin) {
        service.startCharging(vin);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<Void> stopCharging(String vin) {
        service.stopCharging(vin);
        return ResponseEntity.accepted().build();
    }
}
