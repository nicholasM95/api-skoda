package be.nicholas.api.charging.service;

import be.nicholas.api.charging.domain.ChargingSession;
import be.nicholas.api.charging.domain.ChargingState;

import java.util.List;

public interface ChargingClientService {

    ChargingState findChargingStateByVin(String vin);

    List<ChargingSession> getChargingSessionsByVin(String vin);

    void startChargingByVin(String vin);

    void stopChargingByVin(String vin);
}
