package be.nicholas.api.airconditioning.mapper;

import be.nicholas.api.airconditioning.domain.AirConditioning;
import be.nicholas.api.resource.AirConditioningWebRequestResource;
import be.nicholas.api.resource.AirConditioningWebResponseResource;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AirConditioningMapperImpl implements AirConditioningMapper {
    @Override
    public AirConditioningWebResponseResource toWebResource(AirConditioning resource) {
        return AirConditioningWebResponseResource.builder()
                .state(resource.state())
                .temperature(resource.temperature())
                .temperatureUnit(resource.temperatureUnit())
                .carCapturedTimestamp(resource.carCapturedTimestamp())
                .build();
    }

    @Override
    public AirConditioning toDomain(AirConditioningWebRequestResource resource) {
        return new AirConditioning("", resource.getHeaterSource(), Optional.ofNullable(resource.getTemperature()).orElse(0.0),
                resource.getTemperatureUnit(), "");
    }
}
