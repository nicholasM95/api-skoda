package be.nicholas.api.core.host;

import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public interface FindHostService {
    URI getHost(final String id, final String mode);
}
