package be.nicholas.api.flash.mapper;

import be.nicholas.api.flash.domain.Flash;
import be.nicholas.api.resource.FlashWebResponseResource;

public interface FlashMapper {
    FlashWebResponseResource toWebResource(final Flash flash);
}
