package be.nicholas.api.cooling.resource.out;

import java.util.List;

public class DepartureTimersResponseResource {
    private String heaterMode;
    private List<DepartureTimerResponseResource> departureTimer;

    public String getHeaterMode() {
        return heaterMode;
    }

    public void setHeaterMode(String heaterMode) {
        this.heaterMode = heaterMode;
    }

    public List<DepartureTimerResponseResource> getDepartureTimer() {
        return departureTimer;
    }

    public void setDepartureTimer(List<DepartureTimerResponseResource> departureTimer) {
        this.departureTimer = departureTimer;
    }
}
