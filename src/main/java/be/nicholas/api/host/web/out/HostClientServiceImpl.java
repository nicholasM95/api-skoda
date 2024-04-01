package be.nicholas.api.host.web.out;

import be.nicholas.api.host.domain.Host;
import be.nicholas.api.host.resource.out.HostResponseResource;
import be.nicholas.api.host.service.HostClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RequiredArgsConstructor
@Service
public class HostClientServiceImpl implements HostClientService {

    private final HostClient client;

    @Override
    public Host findHostByVin(String vin, String mode) {
        log.info("find host for vin {} and mode {}", vin, mode);
        HostResponseResource resource = client.getHomeRegion(vin);
        URI uri;
        if ("mal".equals(mode)) {
            try {
                uri = new URI(resource.getHomeRegion().getBaseUri().getContent()
                        .replace("/api", "")
                        .replace("mal", "fal"));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e); // TODO throw custom error
            }
        } else {
            try {
                uri = new URI(resource.getHomeRegion().getBaseUri().getContent().replace("/api", ""));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e); // TODO throw custom error
            }
        }
        return new Host(uri);
    }
}
