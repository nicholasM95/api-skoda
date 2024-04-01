package be.nicholas.api.host.service;

import be.nicholas.api.host.domain.Host;

public interface HostClientService {
    Host findHostByVin(String vin, String mode);
}
