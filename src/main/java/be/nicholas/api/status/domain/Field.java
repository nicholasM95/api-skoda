package be.nicholas.api.status.domain;

import java.time.LocalDateTime;

public record Field(String id, LocalDateTime tsCarSentUtc, LocalDateTime tsCarSent, LocalDateTime tsCarCaptured, LocalDateTime tsTssReceivedUtc,
                    Integer milCarCaptured, Integer milCarSent, String value, String unit, String textId) {
}
