package be.nicholas.api.status.web.out;

import be.nicholas.api.status.resource.out.StatusResponseResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface StatusClient {

    @RequestLine("GET /api/v2/vehicle-status/{vin}")
    @Headers({"Accept: application/json"})
    StatusResponseResource getStatus(@Param("vin") String vin);
}
