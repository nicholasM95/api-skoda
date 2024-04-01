package be.nicholas.api.location.web.out;

import be.nicholas.api.location.resource.out.LocationResponseResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.net.URI;

public interface LocationClient {
    @RequestLine("GET /fs-car/bs/cf/v1/skoda/CZ/vehicles/{vin}/position")
    @Headers({"Accept: application/json", "X-App-Version: 3.5.5", "X-App-Name: cz.skodaauto.connect", "X-Client-Id: a83d7e44-c8b7-42b7-b8ca-e478270d2091"})
    LocationResponseResource findPositionByVin(URI baseUri, @Param("vin") String vin);
}
