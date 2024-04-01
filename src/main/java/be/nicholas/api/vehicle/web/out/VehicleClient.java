package be.nicholas.api.vehicle.web.out;

import be.nicholas.api.vehicle.resource.out.VehicleResponseResource;
import feign.Headers;
import feign.RequestLine;

import java.util.List;

public interface VehicleClient {
    @RequestLine("GET /api/v2/garage/vehicles")
    @Headers({"Content-Type: application/json"})
    List<VehicleResponseResource> getVehicles();
}
