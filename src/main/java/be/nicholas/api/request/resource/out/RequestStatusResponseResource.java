package be.nicholas.api.request.resource.out;

public class RequestStatusResponseResource {
    private String vin;
    private String status;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
