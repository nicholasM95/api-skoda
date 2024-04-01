package be.nicholas.api.cooling.domain;

public record Report(String climatisationState, int climatisationDuration, int remainingClimateTime,
                     int climateStatusCode) {
}
