package be.nicholas.api.location.resource.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

public class ParkResponseResource {
    @JsonProperty("Position")
    private LocationInfoResponseResource position;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime parkingTimeUTC;

    public LocationInfoResponseResource getPosition() {
        return position;
    }

    public void setPosition(LocationInfoResponseResource position) {
        this.position = position;
    }

    public LocalDateTime getParkingTimeUTC() {
        return parkingTimeUTC;
    }

    public void setParkingTimeUTC(LocalDateTime parkingTimeUTC) {
        this.parkingTimeUTC = parkingTimeUTC;
    }
}
