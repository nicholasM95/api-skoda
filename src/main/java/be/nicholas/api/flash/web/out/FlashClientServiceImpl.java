package be.nicholas.api.flash.web.out;

import be.nicholas.api.flash.domain.Flash;
import be.nicholas.api.flash.resource.out.FlashCommandRequestResource;
import be.nicholas.api.flash.resource.out.FlashRequestResource;
import be.nicholas.api.flash.resource.out.FlashResponseResource;
import be.nicholas.api.flash.resource.out.PositionRequestResource;
import be.nicholas.api.flash.service.FlashClientService;
import be.nicholas.api.host.service.HostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class FlashClientServiceImpl implements FlashClientService {

    private static final String MODE = "mal";
    private final FlashClient client;
    private final HostService hostService;

    private static FlashRequestResource getFlashRequestResource(Flash flash) {
        PositionRequestResource positionRequestResource = new PositionRequestResource();
        positionRequestResource.setLatitude(flash.latitude());
        positionRequestResource.setLongitude(flash.longitude());

        FlashCommandRequestResource commandRequestResource = new FlashCommandRequestResource();
        commandRequestResource.setUserPosition(positionRequestResource);
        commandRequestResource.setServiceDuration(flash.duration());
        commandRequestResource.setServiceOperationCode("FLASH_ONLY");

        FlashRequestResource requestResource = new FlashRequestResource();
        requestResource.setHonkAndFlashRequest(commandRequestResource);
        return requestResource;
    }

    @Override
    public Flash flash(Flash flash) {
        log.info("flash for vin {}, with duration {}", flash.vin(), flash.duration());
        FlashRequestResource requestResource = getFlashRequestResource(flash);

        FlashResponseResource responseResource = client.flash(hostService.getHost(flash.vin(), MODE), flash.vin(), requestResource);

        String requestId = responseResource.getHonkAndFlashRequest().getId();
        String service = responseResource.getHonkAndFlashRequest().getServiceOperationCode();
        String status = responseResource.getHonkAndFlashRequest().getStatus().getStatusCode();
        LocalDateTime lastUpdated = responseResource.getHonkAndFlashRequest().getLastUpdated();

        return new Flash(flash.vin(), flash.latitude(), flash.longitude(), flash.duration(), requestId, service, status, lastUpdated);
    }
}
