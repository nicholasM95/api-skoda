package be.nicholas.api.pin.web.out;

import be.nicholas.api.pin.resource.out.PinResponseResource;
import be.nicholas.api.pin.resource.out.TokenResponseResource;
import be.nicholas.api.pin.resource.out.PinRequestResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;


public interface PinClient {
    @RequestLine("GET /api/rolesrights/authorization/v2/vehicles/{vin}/services/rheating_v1/operations/P_QSACT/security-pin-auth-requested")
    @Headers({"Accept: application/json"})
    PinResponseResource prepareLogin(@Param("vin") String vin);

    @RequestLine("POST /api/rolesrights/authorization/v2/security-pin-auth-completed")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    TokenResponseResource doLogin(@RequestBody PinRequestResource resource);
}
