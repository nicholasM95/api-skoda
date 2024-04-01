package be.nicholas.api.role.service;

import be.nicholas.api.role.domain.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleClientService service;

    public Role getRoles(String vin) {
        log.info("get roles for {}", vin);
        return service.getRole(vin);
    }
}
