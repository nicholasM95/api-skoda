package be.nicholas.api.host.web.out;

import be.nicholas.api.cache.HostCache;
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
    private final HostCache cache;

    @Override
    public Host findHostByVin(String vin, String mode) {
        if (cache.isCached(vin, mode)) {
            log.info("get host for vin {} and mode {} from cache", vin, mode);
            return cache.getHost(vin, mode);
        } else {
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
            Host host = new Host(uri);
            cache.addHost(vin, mode, host);
            return host;
        }
    }
}
