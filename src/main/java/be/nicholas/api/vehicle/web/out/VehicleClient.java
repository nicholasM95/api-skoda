package be.nicholas.api.vehicle.web.out;

import be.nicholas.api.vehicle.resource.out.VehicleGarageResponseResource;
import feign.Headers;
import feign.RequestLine;

public interface VehicleClient {
    @RequestLine("GET /api/v2/garage")
    @Headers({"Content-Type: application/json"})
    VehicleGarageResponseResource getVehicles();
}
