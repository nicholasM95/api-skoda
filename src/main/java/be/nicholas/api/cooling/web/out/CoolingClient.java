package be.nicholas.api.cooling.web.out;

import be.nicholas.api.cooling.resource.out.CoolingResponseResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.net.URI;

public interface CoolingClient {

    @RequestLine("GET /fs-car/bs/rs/v1/skoda/CZ/vehicles/{vin}/status")
    @Headers({"Accept: application/json", "X-App-Version: 3.5.5", "X-App-Name: cz.skodaauto.connect", "X-Client-Id: a83d7e44-c8b7-42b7-b8ca-e478270d2091"})
    CoolingResponseResource getStatus(URI baseUri, @Param("vin") String vin);
}
