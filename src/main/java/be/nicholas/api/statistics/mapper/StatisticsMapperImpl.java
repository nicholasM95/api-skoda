package be.nicholas.api.statistics.mapper;

import be.nicholas.api.resource.StatisticsWebResponseResource;
import be.nicholas.api.statistics.domain.Statistics;
import org.springframework.stereotype.Component;

@Component
public class StatisticsMapperImpl implements StatisticsMapper {
    @Override
    public StatisticsWebResponseResource toWebResource(final Statistics statistics) {
        return StatisticsWebResponseResource.builder()
                .overallMileage(statistics.overallMileage())
                .tripType(statistics.tripType())
                .averageFuelConsumption(statistics.averageFuelConsumption())
                .travelTime(statistics.travelTime())
                .startMileage(statistics.startMileage())
                .tripId(statistics.tripId())
                .averageSpeed(statistics.averageSpeed())
                .mileage(statistics.mileage())
                .timestamp(statistics.timestamp())
                .reportReason(statistics.reportReason())
                .build();
    }
}
