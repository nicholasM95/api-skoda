package be.nicholas.api.location.mapper;

import be.nicholas.api.location.domain.Location;
import be.nicholas.api.resource.LocationWebResponseResource;

public interface LocationMapper {
    LocationWebResponseResource toWebResource(final Location resource);
}
