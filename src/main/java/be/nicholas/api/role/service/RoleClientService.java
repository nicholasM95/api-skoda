package be.nicholas.api.role.service;

import be.nicholas.api.role.domain.Role;

public interface RoleClientService {

    Role getRole(String vin);
}
