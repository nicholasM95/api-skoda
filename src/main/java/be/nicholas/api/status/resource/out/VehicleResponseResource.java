package be.nicholas.api.status.resource.out;

public class VehicleResponseResource {
    private String vin;
    private VehicleDataResponseResource vehicleData;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public VehicleDataResponseResource getVehicleData() {
        return vehicleData;
    }

    public void setVehicleData(VehicleDataResponseResource vehicleData) {
        this.vehicleData = vehicleData;
    }
}
