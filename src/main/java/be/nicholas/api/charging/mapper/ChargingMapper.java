package be.nicholas.api.charging.mapper;

import be.nicholas.api.charging.domain.ChargingSession;
import be.nicholas.api.charging.domain.ChargingState;
import be.nicholas.api.resource.ChargingSessionWebResponseResource;
import be.nicholas.api.resource.ChargingStatusWebResponseResource;

public interface ChargingMapper {

    ChargingStatusWebResponseResource toWebResponseResource(ChargingState chargingState);

    ChargingSessionWebResponseResource toWebResponseResource(ChargingSession chargingSession);
}
