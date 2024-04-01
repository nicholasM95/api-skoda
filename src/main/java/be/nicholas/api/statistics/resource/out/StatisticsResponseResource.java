package be.nicholas.api.statistics.resource.out;

public class StatisticsResponseResource {
    private TripDataResponseResource tripData;

    public TripDataResponseResource getTripData() {
        return tripData;
    }

    public void setTripData(TripDataResponseResource tripData) {
        this.tripData = tripData;
    }
}
