package be.nicholas.api.role.web.in;

import be.nicholas.api.controller.RoleApi;
import be.nicholas.api.resource.RoleWebResponseResource;
import be.nicholas.api.role.domain.Role;
import be.nicholas.api.role.mapper.RoleMapper;
import be.nicholas.api.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RoleWebController implements RoleApi {
    private final RoleService service;
    private final RoleMapper mapper;

    @Override
    public ResponseEntity<RoleWebResponseResource> getRole(String vin) {
        Role role = service.getRoles(vin);
        return ResponseEntity.ok(mapper.toWebResource(role));
    }
}
