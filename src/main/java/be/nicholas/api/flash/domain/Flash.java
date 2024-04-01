package be.nicholas.api.flash.domain;

import java.time.LocalDateTime;

public record Flash(String vin, int latitude, int longitude, int duration, String requestId, String service, String status, LocalDateTime lastUpdated) {
}
