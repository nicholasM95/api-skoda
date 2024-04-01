package be.nicholas.api.location.web.out;

import be.nicholas.api.core.host.FindHostService;
import be.nicholas.api.location.domain.Location;
import be.nicholas.api.location.resource.out.LocationResponseResource;
import be.nicholas.api.location.service.LocationClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@Service
public class LocationClientServiceImpl implements LocationClientService {

    private static final String MODE = "mal";
    private final LocationClient client;
    private final FindHostService hostService;

    @Override
    public Location findLocationByVin(String vin) {
        log.info("find location for vin {}", vin);
        URI uri = hostService.getHost(vin, MODE);
        LocationResponseResource responseResource = client.findPositionByVin(uri, vin);
        return new Location(responseResource.getFindCarResponse().getPosition().getCarCoordinate().getLatitude(),
                responseResource.getFindCarResponse().getPosition().getCarCoordinate().getLongitude(),
                responseResource.getFindCarResponse().getParkingTimeUTC());
    }
}
