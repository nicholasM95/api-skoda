package be.nicholas.api.request.web.out;

import be.nicholas.api.host.service.HostService;
import be.nicholas.api.request.domain.Request;
import be.nicholas.api.request.resource.out.RequestResponseResource;
import be.nicholas.api.request.service.RequestClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@Service
public class RequestClientServiceImpl implements RequestClientService {

    private static final String MODE = "mal";
    private final RequestClient client;
    private final HostService hostService;

    @Override
    public Request getRequestInfoByVinAndId(String vin, String id) {
        log.info("get request for vin {} and id {}", vin, id);
        URI uri = hostService.getHost(vin, MODE);
        RequestResponseResource response = client.getRequestStatus(uri, vin, id);
        return new Request(response.getRequestStatusResponse().getVin(), response.getRequestStatusResponse().getStatus());
    }
}
