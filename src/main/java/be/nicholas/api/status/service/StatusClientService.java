package be.nicholas.api.status.service;

import be.nicholas.api.status.domain.Status;

public interface StatusClientService {
    Status getStatusByVin(String vin);
}
