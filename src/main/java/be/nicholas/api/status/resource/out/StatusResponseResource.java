package be.nicholas.api.status.resource.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusResponseResource {
    @JsonProperty("StoredVehicleDataResponse")
    private VehicleResponseResource storedVehicleDataResponse;

    public VehicleResponseResource getStoredVehicleDataResponse() {
        return storedVehicleDataResponse;
    }

    public void setStoredVehicleDataResponse(VehicleResponseResource storedVehicleDataResponse) {
        this.storedVehicleDataResponse = storedVehicleDataResponse;
    }
}
