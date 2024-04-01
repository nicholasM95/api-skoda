package be.nicholas.api.flash.web.out;

import be.nicholas.api.flash.resource.out.FlashRequestResource;
import be.nicholas.api.flash.resource.out.FlashResponseResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

public interface FlashClient {
    @RequestLine("POST /fs-car/bs/rhf/v1/skoda/CZ/vehicles/{vin}/honkAndFlash")
    @Headers({"Accept: application/json", "Content-Type: application/json", "X-App-Version: 3.5.5", "X-App-Name: cz.skodaauto.connect", "X-Client-Id: a83d7e44-c8b7-42b7-b8ca-e478270d2091"})
    FlashResponseResource flash(URI baseUri, @Param("vin") String vin, @RequestBody FlashRequestResource resource);
}
