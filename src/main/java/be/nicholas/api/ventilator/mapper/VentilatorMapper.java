package be.nicholas.api.ventilator.mapper;

import be.nicholas.api.resource.VentilatorWebResponseResource;
import be.nicholas.api.ventilator.domain.Ventilator;

public interface VentilatorMapper {

    VentilatorWebResponseResource toWebResource(final Ventilator ventilator);
}
