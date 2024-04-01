package be.nicholas.api.status.web.in;

import be.nicholas.api.controller.StatusApi;
import be.nicholas.api.resource.StatusWebResponseResource;
import be.nicholas.api.status.domain.Status;
import be.nicholas.api.status.mapper.StatusMapper;
import be.nicholas.api.status.service.StatusClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class StatusWebController implements StatusApi {
    private final StatusMapper mapper;
    private final StatusClientService service;

    @Override
    public ResponseEntity<StatusWebResponseResource> getStatus(String vin) {
        Status status = service.getStatusByVin(vin);
        return ResponseEntity.ok(mapper.toWebResource(status));
    }
}
