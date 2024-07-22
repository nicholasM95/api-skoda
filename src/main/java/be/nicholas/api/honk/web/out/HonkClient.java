package be.nicholas.api.honk.web.out;

import be.nicholas.api.honk.resource.out.HonkRequestResource;
import be.nicholas.api.honk.resource.out.HonkResponseResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

public interface HonkClient {
    @RequestLine("POST /fs-car/bs/rhf/v1/skoda/CZ/vehicles/{vin}/honkAndFlash")
    @Headers({"Accept: application/json", "Content-Type: application/json", "X-App-Version: 3.5.5", "X-App-Name: cz.skodaauto.connect", "X-Client-Id: a83d7e44-c8b7-42b7-b8ca-e478270d2091"})
    HonkResponseResource honk(URI baseUri, @Param("vin") String vin, @RequestBody HonkRequestResource resource);
}
