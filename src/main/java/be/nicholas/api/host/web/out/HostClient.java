package be.nicholas.api.host.web.out;

import be.nicholas.api.host.resource.out.HostResponseResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface HostClient {
    @RequestLine("GET /api/cs/vds/v1/vehicles/{id}/homeRegion")
    @Headers({"Accept: application/json"})
    HostResponseResource getHomeRegion(@Param("id") String id);
}
