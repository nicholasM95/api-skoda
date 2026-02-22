package be.nicholas.api.airconditioning.mapper;

import be.nicholas.api.airconditioning.domain.AirConditioning;
import be.nicholas.api.resource.AirConditioningWebRequestResource;
import be.nicholas.api.resource.AirConditioningWebResponseResource;

public interface AirConditioningMapper {

    AirConditioningWebResponseResource toWebResource(final AirConditioning resource);

    AirConditioning toDomain(final AirConditioningWebRequestResource resource);

}
