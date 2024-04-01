package be.nicholas.api.request.service;

import be.nicholas.api.request.domain.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RequestService {

    private final RequestClientService service;

    public Request getRequestStatus(String vin, String requestId) {
        log.info("get request status for {} with id {}", vin, requestId);
        return service.getRequestInfoByVinAndId(vin, requestId);
    }
}
