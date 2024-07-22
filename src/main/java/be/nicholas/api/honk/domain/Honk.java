package be.nicholas.api.honk.domain;

import java.time.LocalDateTime;

public record Honk(String vin, int latitude, int longitude, int duration, String requestId, String service, String status, LocalDateTime lastUpdated) {
}
