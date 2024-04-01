package be.nicholas.api.cooling.domain;

import java.time.LocalDateTime;
import java.util.List;

public record Cooling(LocalDateTime instrumentClusterTime, LocalDateTime carCapturedUTCTimestamp,
                      LocalDateTime vehicleParkingClock, String outdoorTempValid, int outdoorTemp,
                      LocalDateTime temperatureTime, int climatisationDuration, String startMode,
                      String heaterMode, Report report, List<Timer> timers) {
}
