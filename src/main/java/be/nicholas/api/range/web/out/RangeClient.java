package be.nicholas.api.range.web.out;

import be.nicholas.api.range.resource.out.RangeResponseResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface RangeClient {
    @RequestLine("GET /api/v2/vehicle-status/{vin}/driving-range")
    @Headers({"Accept: application/json"})
    RangeResponseResource findRangeByVin(@Param("vin") String vin);
}
