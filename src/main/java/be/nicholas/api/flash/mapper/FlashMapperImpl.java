package be.nicholas.api.flash.mapper;

import be.nicholas.api.flash.domain.Flash;
import be.nicholas.api.resource.FlashWebResponseResource;
import org.springframework.stereotype.Component;

@Component
public class FlashMapperImpl implements FlashMapper {
    @Override
    public FlashWebResponseResource toWebResource(final Flash flash) {
        return FlashWebResponseResource.builder()
                .id(flash.requestId())
                .status(flash.status())
                .duration(flash.duration())
                .lastUpdated(flash.lastUpdated())
                .build();
    }
}
