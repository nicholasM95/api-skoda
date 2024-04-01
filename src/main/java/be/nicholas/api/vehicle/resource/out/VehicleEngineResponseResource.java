package be.nicholas.api.vehicle.resource.out;

public class VehicleEngineResponseResource {
    private String type;
    private String powerInKW;
    private String capacityInLiters;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPowerInKW() {
        return powerInKW;
    }

    public void setPowerInKW(String powerInKW) {
        this.powerInKW = powerInKW;
    }

    public String getCapacityInLiters() {
        return capacityInLiters;
    }

    public void setCapacityInLiters(String capacityInLiters) {
        this.capacityInLiters = capacityInLiters;
    }
}
