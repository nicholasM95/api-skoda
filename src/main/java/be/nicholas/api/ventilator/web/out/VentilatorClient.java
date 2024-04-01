package be.nicholas.api.ventilator.web.out;

import be.nicholas.api.ventilator.resource.out.VentilatorRequestResource;
import be.nicholas.api.ventilator.resource.out.VentilatorResponseResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

public interface VentilatorClient {
    @RequestLine("POST /fs-car/bs/rs/v1/skoda/CZ/vehicles/{vin}/action")
    @Headers({"Accept: application/json", "Content-Type: application/json", "X-App-Version: 3.5.5", "X-App-Name: cz.skodaauto.connect", "X-Client-Id: a83d7e44-c8b7-42b7-b8ca-e478270d2091"})
    VentilatorResponseResource stopVentilator(URI baseUri, @Param("vin") String vin, @RequestBody VentilatorRequestResource resource);

    @RequestLine("POST /fs-car/bs/rs/v1/skoda/CZ/vehicles/{vin}/action")
    @Headers({"x-mbbSecToken: {sec-token}", "tokentype: MBB", "Accept: application/json", "Content-Type: application/vnd.vwg.mbb.RemoteStandheizung_v2_0_2+json", "X-App-Version: 3.5.5", "X-App-Name: cz.skodaauto.connect", "X-Client-Id: a83d7e44-c8b7-42b7-b8ca-e478270d2091"})
    VentilatorResponseResource startVentilator(URI baseUri, @Param("vin") String vin, @Param("sec-token") String secToken, @RequestBody VentilatorRequestResource resource);
}
