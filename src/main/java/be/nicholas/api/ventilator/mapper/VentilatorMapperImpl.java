package be.nicholas.api.ventilator.mapper;

import be.nicholas.api.resource.VentilatorWebResponseResource;
import be.nicholas.api.ventilator.domain.Ventilator;
import org.springframework.stereotype.Component;

@Component
public class VentilatorMapperImpl implements VentilatorMapper {

    @Override
    public VentilatorWebResponseResource toWebResource(final Ventilator ventilator) {
        return VentilatorWebResponseResource.builder()
                .id(ventilator.requestId())
                .vin(ventilator.vin())
                .build();
    }
}
