package be.nicholas.api.vehicle.domain;

import java.time.LocalDateTime;

public record Vehicle(String id, String vin, String name, LocalDateTime lastUpdated) {
}
