package be.nicholas.api.statistics.web.out;

import be.nicholas.api.statistics.resource.out.StatisticsResponseResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.net.URI;

public interface StatisticsClient {
    @RequestLine("GET /fs-car/bs/tripstatistics/v1/skoda/CZ/vehicles/{vin}/tripdata/shortTerm?newest")
    @Headers({"Accept: application/json"})
    StatisticsResponseResource getStatistics(URI baseUri, @Param("vin") String vin);
}
