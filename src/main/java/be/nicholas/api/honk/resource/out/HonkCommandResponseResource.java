package be.nicholas.api.honk.resource.out;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

public class HonkCommandResponseResource {
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime lastUpdated;
    private int serviceDuration;
    private PositionResponseResource userPosition;
    private String id;
    private String serviceOperationCode;
    private StatusResponseResource status;

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(int serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public PositionResponseResource getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(PositionResponseResource userPosition) {
        this.userPosition = userPosition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceOperationCode() {
        return serviceOperationCode;
    }

    public void setServiceOperationCode(String serviceOperationCode) {
        this.serviceOperationCode = serviceOperationCode;
    }

    public StatusResponseResource getStatus() {
        return status;
    }

    public void setStatus(StatusResponseResource status) {
        this.status = status;
    }
}
