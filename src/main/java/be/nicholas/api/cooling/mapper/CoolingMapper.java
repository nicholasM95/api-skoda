package be.nicholas.api.cooling.mapper;

import be.nicholas.api.cooling.domain.Cooling;
import be.nicholas.api.resource.CoolingWebResponseResource;

public interface CoolingMapper {
    CoolingWebResponseResource toWebResource(final Cooling cooling);
}
