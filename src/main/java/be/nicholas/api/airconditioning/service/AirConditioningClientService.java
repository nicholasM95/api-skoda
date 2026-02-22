package be.nicholas.api.airconditioning.service;

import be.nicholas.api.airconditioning.domain.AirConditioning;

public interface AirConditioningClientService {

    AirConditioning findAirConditioningByVin(String vin);

    void startAirConditioning(String vin, AirConditioning airConditioning);

    void stopAirConditioning(String vin);
}
