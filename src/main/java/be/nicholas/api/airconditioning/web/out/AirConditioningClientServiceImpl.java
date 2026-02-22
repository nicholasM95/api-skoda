package be.nicholas.api.airconditioning.web.out;

import be.nicholas.api.airconditioning.domain.AirConditioning;
import be.nicholas.api.airconditioning.resource.out.AirConditioningResponseResource;
import be.nicholas.api.airconditioning.resource.out.AirConditioningStartRequestResource;
import be.nicholas.api.airconditioning.resource.out.AirConditioningTargetTemperatureStartRequestResource;
import be.nicholas.api.airconditioning.service.AirConditioningClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AirConditioningClientServiceImpl implements AirConditioningClientService {

    private final AirConditioningClient client;

    @Override
    public AirConditioning findAirConditioningByVin(String vin) {
        log.info("find air conditioning for vin {}", vin);
        AirConditioningResponseResource responseResource = client.findAirConditioningByVin(vin);
        return new AirConditioning(responseResource.getState(), "", responseResource.getTargetTemperature().getTemperatureValue(),
                responseResource.getTargetTemperature().getUnitInCar(), responseResource.getCarCapturedTimestamp());
    }

    @Override
    public void startAirConditioning(String vin, AirConditioning airConditioning) {
        log.info("start air conditioning for vin {}", vin);
        AirConditioningTargetTemperatureStartRequestResource targetTemperatureRequestResource = new AirConditioningTargetTemperatureStartRequestResource();
        targetTemperatureRequestResource.setTemperatureValue(airConditioning.temperature());
        targetTemperatureRequestResource.setUnitInCar(airConditioning.temperatureUnit());

        AirConditioningStartRequestResource requestResource = new AirConditioningStartRequestResource();
        requestResource.setHeaterSource(airConditioning.heaterSource());
        requestResource.setTargetTemperature(targetTemperatureRequestResource);
        client.startAirConditioningByVin(vin, requestResource);
    }

    @Override
    public void stopAirConditioning(String vin) {
        log.info("stop air conditioning for vin {}", vin);
        client.stopAirConditioningByVin(vin);
    }
}
