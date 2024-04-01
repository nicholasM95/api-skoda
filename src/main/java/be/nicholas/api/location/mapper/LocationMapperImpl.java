package be.nicholas.api.location.mapper;

import be.nicholas.api.location.domain.Location;
import be.nicholas.api.resource.LocationWebResponseResource;
import org.springframework.stereotype.Component;

@Component
public class LocationMapperImpl implements LocationMapper {
    @Override
    public LocationWebResponseResource toWebResource(final Location location) {
        return LocationWebResponseResource.builder()
                .latitude(location.latitude())
                .longitude(location.longitude())
                .parkingTime(location.parkingTime())
                .build();
    }
}
