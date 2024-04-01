package be.nicholas.api.pin.service;

import be.nicholas.api.pin.domain.Pin;

public interface PinClientService {

    String getSecurityCode(Pin pin);
}
