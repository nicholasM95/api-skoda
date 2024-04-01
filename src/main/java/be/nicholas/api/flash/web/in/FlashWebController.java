package be.nicholas.api.flash.web.in;

import be.nicholas.api.controller.FlashApi;
import be.nicholas.api.flash.domain.Flash;
import be.nicholas.api.flash.service.FlashService;
import be.nicholas.api.resource.FlashWebRequestResource;
import be.nicholas.api.resource.FlashWebResponseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@RestController
public class FlashWebController implements FlashApi {
    private final FlashService service;

    @Override
    public ResponseEntity<FlashWebResponseResource> flash(String vin, FlashWebRequestResource flashWebRequestResource) {
        Flash flash = service.flash(vin, flashWebRequestResource.getLatitude(), flashWebRequestResource.getLongitude(), flashWebRequestResource.getDuration());
        UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/request/{vin}/{id}").buildAndExpand(vin, flash.requestId());
        FlashWebResponseResource response = FlashWebResponseResource.builder()
                .id(flash.requestId())
                .status(flash.status())
                .duration(flash.duration())
                .lastUpdated(flash.lastUpdated())
                .build();
        return ResponseEntity.created(uriComponents.toUri()).body(response);
    }
}
