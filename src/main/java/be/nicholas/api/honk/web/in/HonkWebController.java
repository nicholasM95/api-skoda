package be.nicholas.api.honk.web.in;

import be.nicholas.api.controller.HonkApi;
import be.nicholas.api.honk.domain.Honk;
import be.nicholas.api.honk.service.HonkService;
import be.nicholas.api.resource.HonkWebRequestResource;
import be.nicholas.api.resource.HonkWebResponseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@RestController
public class HonkWebController implements HonkApi {

    private final HonkService service;

    @Override
    public ResponseEntity<HonkWebResponseResource> honk(String vin, HonkWebRequestResource honkWebRequestResource) {
        Honk honk = service.honk(vin, honkWebRequestResource.getLatitude(), honkWebRequestResource.getLongitude(), honkWebRequestResource.getDuration());
        UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/request/{vin}/{id}").buildAndExpand(vin, honk.requestId());
        HonkWebResponseResource response = HonkWebResponseResource.builder()
                .id(honk.requestId())
                .status(honk.status())
                .duration(honk.duration())
                .lastUpdated(honk.lastUpdated())
                .build();
        return ResponseEntity.created(uriComponents.toUri()).body(response);
    }
}
