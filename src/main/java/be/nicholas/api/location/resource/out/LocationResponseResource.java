package be.nicholas.api.location.resource.out;

public class LocationResponseResource {
    private ParkResponseResource findCarResponse;

    public ParkResponseResource getFindCarResponse() {
        return findCarResponse;
    }

    public void setFindCarResponse(ParkResponseResource findCarResponse) {
        this.findCarResponse = findCarResponse;
    }
}
