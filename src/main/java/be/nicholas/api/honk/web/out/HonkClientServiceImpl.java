package be.nicholas.api.honk.web.out;

import be.nicholas.api.honk.domain.Honk;
import be.nicholas.api.honk.resource.out.HonkCommandRequestResource;
import be.nicholas.api.honk.resource.out.HonkRequestResource;
import be.nicholas.api.honk.resource.out.HonkResponseResource;
import be.nicholas.api.honk.resource.out.PositionRequestResource;
import be.nicholas.api.honk.service.HonkClientService;
import be.nicholas.api.host.service.HostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class HonkClientServiceImpl implements HonkClientService {

    private static final String MODE = "mal";
    private final HonkClient client;
    private final HostService hostService;

    private static HonkRequestResource getHonkRequestResource(Honk honk) {
        PositionRequestResource positionRequestResource = new PositionRequestResource();
        positionRequestResource.setLatitude(honk.latitude());
        positionRequestResource.setLongitude(honk.longitude());

        HonkCommandRequestResource commandRequestResource = new HonkCommandRequestResource();
        commandRequestResource.setUserPosition(positionRequestResource);
        commandRequestResource.setServiceDuration(honk.duration());
        commandRequestResource.setServiceOperationCode("HONK_AND_FLASH");

        HonkRequestResource requestResource = new HonkRequestResource();
        requestResource.setHonkAndFlashRequest(commandRequestResource);
        return requestResource;
    }

    @Override
    public Honk honk(Honk honk) {
        log.info("honk for vin {}, with duration {}", honk.vin(), honk.duration());
        HonkRequestResource requestResource = getHonkRequestResource(honk);

        HonkResponseResource responseResource = client.honk(hostService.getHost(honk.vin(), MODE), honk.vin(), requestResource);

        String requestId = responseResource.getHonkAndFlashRequest().getId();
        String service = responseResource.getHonkAndFlashRequest().getServiceOperationCode();
        String status = responseResource.getHonkAndFlashRequest().getStatus().getStatusCode();
        LocalDateTime lastUpdated = responseResource.getHonkAndFlashRequest().getLastUpdated();

        return new Honk(honk.vin(), honk.latitude(), honk.longitude(), honk.duration(), requestId, service, status, lastUpdated);
    }
}
