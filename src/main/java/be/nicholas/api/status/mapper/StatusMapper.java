package be.nicholas.api.status.mapper;

import be.nicholas.api.resource.StatusWebResponseResource;
import be.nicholas.api.status.domain.Status;

public interface StatusMapper {
    StatusWebResponseResource toWebResource(final Status status);
}
