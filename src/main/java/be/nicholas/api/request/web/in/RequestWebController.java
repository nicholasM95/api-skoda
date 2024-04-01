package be.nicholas.api.request.web.in;

import be.nicholas.api.controller.RequestApi;
import be.nicholas.api.request.domain.Request;
import be.nicholas.api.request.service.RequestService;
import be.nicholas.api.resource.RequestWebResponseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RequestWebController implements RequestApi {
    private final RequestService service;

    @Override
    public ResponseEntity<RequestWebResponseResource> getRequest(String vin, String id) {
        Request request = service.getRequestStatus(vin, id);
        RequestWebResponseResource response = RequestWebResponseResource.builder()
                .vin(request.vin())
                .status(request.status())
                .build();

        return ResponseEntity.ok(response);
    }
}
