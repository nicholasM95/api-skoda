package be.nicholas.api.request.mapper;

import be.nicholas.api.request.domain.Request;
import be.nicholas.api.resource.RequestWebResponseResource;
import org.springframework.stereotype.Component;

@Component
public class RequestMapperImpl implements RequestMapper {
    @Override
    public RequestWebResponseResource toWebResource(final Request request) {
        return RequestWebResponseResource.builder()
                .vin(request.vin())
                .status(request.status())
                .build();
    }
}
