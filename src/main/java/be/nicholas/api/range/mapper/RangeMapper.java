package be.nicholas.api.range.mapper;

import be.nicholas.api.range.domain.Range;
import be.nicholas.api.resource.RangeWebResponseResource;

public interface RangeMapper {

    RangeWebResponseResource toWebResource(final Range resource);
}
