package be.nicholas.api.request.web.out;

import be.nicholas.api.request.resource.out.RequestResponseResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.net.URI;

public interface RequestClient {
    @RequestLine("GET /fs-car/bs/rs/v1/skoda/CZ/vehicles/{id}/requests/{request-id}/status")
    @Headers({"Accept: application/json", "X-App-Version: 3.5.5", "X-App-Name: cz.skodaauto.connect", "X-Client-Id: a83d7e44-c8b7-42b7-b8ca-e478270d2091"})
    RequestResponseResource getRequestStatus(URI baseUri, @Param("id") String id, @Param("request-id") String requestId);
}
