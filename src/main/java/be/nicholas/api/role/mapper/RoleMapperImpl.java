package be.nicholas.api.role.mapper;

import be.nicholas.api.resource.RoleWebResponseResource;
import be.nicholas.api.role.domain.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapperImpl implements RoleMapper {
    @Override
    public RoleWebResponseResource toWebResource(final Role role) {
        return RoleWebResponseResource.builder()
                .services(role.services())
                .build();
    }
}
