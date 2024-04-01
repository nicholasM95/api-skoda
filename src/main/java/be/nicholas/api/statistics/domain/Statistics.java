package be.nicholas.api.statistics.domain;

import java.time.LocalDateTime;

public record Statistics(Integer overallMileage, String tripType, Integer averageFuelConsumption,
                         Integer travelTime, Integer startMileage, String tripId, Integer averageSpeed, Integer mileage,
                         LocalDateTime timestamp, String reportReason) {
}
