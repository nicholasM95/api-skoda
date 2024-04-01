package be.nicholas.api.location.resource.out;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

public class LocationInfoResponseResource {
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timestampCarSent;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timestampTssReceived;
    private PositionResponseResource carCoordinate;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timestampCarSentUTC;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timestampCarCaptured;

    public LocalDateTime getTimestampCarSent() {
        return timestampCarSent;
    }

    public void setTimestampCarSent(LocalDateTime timestampCarSent) {
        this.timestampCarSent = timestampCarSent;
    }

    public LocalDateTime getTimestampTssReceived() {
        return timestampTssReceived;
    }

    public void setTimestampTssReceived(LocalDateTime timestampTssReceived) {
        this.timestampTssReceived = timestampTssReceived;
    }

    public PositionResponseResource getCarCoordinate() {
        return carCoordinate;
    }

    public void setCarCoordinate(PositionResponseResource carCoordinate) {
        this.carCoordinate = carCoordinate;
    }

    public LocalDateTime getTimestampCarSentUTC() {
        return timestampCarSentUTC;
    }

    public void setTimestampCarSentUTC(LocalDateTime timestampCarSentUTC) {
        this.timestampCarSentUTC = timestampCarSentUTC;
    }

    public LocalDateTime getTimestampCarCaptured() {
        return timestampCarCaptured;
    }

    public void setTimestampCarCaptured(LocalDateTime timestampCarCaptured) {
        this.timestampCarCaptured = timestampCarCaptured;
    }
}
