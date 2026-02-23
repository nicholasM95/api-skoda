package be.nicholas.api.charging.resource.out;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargingHistoryResponseResource {
    private String nextCursor;
    private ChargingHistoryPeriodResponseResource periods;
}
