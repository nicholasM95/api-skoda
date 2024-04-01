package be.nicholas.api.host.service;

import be.nicholas.api.core.host.FindHostService;
import be.nicholas.api.host.domain.Host;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@Service
public class HostService implements FindHostService {
    private final HostClientService service;

    @Override
    public URI getHost(final String vin, final String mode) {
        log.info("get host for {} with mode {}", vin, mode);
        Host host = service.findHostByVin(vin, mode);
        return host.uri();
    }
}
