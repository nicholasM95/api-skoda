package be.nicholas.api.role.web.out;

import be.nicholas.api.host.service.HostService;
import be.nicholas.api.role.domain.Role;
import be.nicholas.api.role.resource.out.RoleResponseResource;
import be.nicholas.api.role.service.RoleClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleClientServiceImpl implements RoleClientService {

    private static final String MODE = "fal";
    private final RoleClient client;
    private final HostService hostService;

    @Override
    public Role getRole(String vin) {
        log.info("get role for vin {}", vin);
        URI uri = hostService.getHost(vin, MODE);
        RoleResponseResource response = client.getRoles(uri, vin);
        return new Role(response.getOperationList().getServiceInfo());
    }
}
