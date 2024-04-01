package be.nicholas.api.role.web.out;

import be.nicholas.api.role.resource.out.RoleResponseResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.net.URI;

public interface RoleClient {

    @RequestLine("GET /api/rolesrights/operationlist/v3/vehicles/{vin}")
    @Headers({"Accept: application/json"})
    RoleResponseResource getRoles(URI baseUri, @Param("vin") String vin);
}
