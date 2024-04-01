package be.nicholas.api.statistics.mapper;

import be.nicholas.api.resource.StatisticsWebResponseResource;
import be.nicholas.api.statistics.domain.Statistics;

public interface StatisticsMapper {
    StatisticsWebResponseResource toWebResource(final Statistics statistics);
}
