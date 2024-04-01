package be.nicholas.api.ventilator.service;

import be.nicholas.api.ventilator.domain.Ventilator;

public interface VentilatorClientService {
    Ventilator startVentilator(Ventilator ventilator);

    Ventilator stopVentilator(Ventilator ventilator);
}
