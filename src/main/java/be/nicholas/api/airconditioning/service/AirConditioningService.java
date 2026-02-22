package be.nicholas.api.airconditioning.service;

import be.nicholas.api.airconditioning.domain.AirConditioning;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class AirConditioningService {

    private final AirConditioningClientService service;

    public AirConditioning getAirConditioning(String vin) {
        return service.findAirConditioningByVin(vin);
    }

    public void startAirConditioning(String vin, AirConditioning airConditioning) {
        service.startAirConditioning(vin, airConditioning);
    }

    public void stopAirConditioning(String vin) {
        service.stopAirConditioning(vin);
    }
}
