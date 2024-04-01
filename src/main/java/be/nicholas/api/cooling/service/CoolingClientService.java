package be.nicholas.api.cooling.service;

import be.nicholas.api.cooling.domain.Cooling;

public interface CoolingClientService {

    Cooling getCoolingByVin(String vin);
}
