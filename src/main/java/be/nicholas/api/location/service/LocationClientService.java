package be.nicholas.api.location.service;

import be.nicholas.api.location.domain.Location;

public interface LocationClientService {

    Location findLocationByVin(String vin);
}
