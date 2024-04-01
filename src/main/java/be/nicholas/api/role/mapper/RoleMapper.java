package be.nicholas.api.role.mapper;

import be.nicholas.api.resource.RoleWebResponseResource;
import be.nicholas.api.role.domain.Role;

public interface RoleMapper {

    RoleWebResponseResource toWebResource(final Role role);
}
