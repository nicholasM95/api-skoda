package be.nicholas.api.cooling.resource.out;

public class DepartureTimersReportResponseResource {
    private DepartureTimersResponseResource departureTimers;

    public DepartureTimersResponseResource getDepartureTimers() {
        return departureTimers;
    }

    public void setDepartureTimers(DepartureTimersResponseResource departureTimers) {
        this.departureTimers = departureTimers;
    }
}
