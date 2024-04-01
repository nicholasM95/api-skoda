package be.nicholas.api.location.domain;

import java.time.LocalDateTime;

public record Location(int latitude, int longitude, LocalDateTime parkingTime) {
}
