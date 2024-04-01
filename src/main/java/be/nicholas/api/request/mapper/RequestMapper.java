package be.nicholas.api.request.mapper;

import be.nicholas.api.request.domain.Request;
import be.nicholas.api.resource.RequestWebResponseResource;

public interface RequestMapper {
    RequestWebResponseResource toWebResource(final Request request);
}
