package be.nicholas.api.vehicle.web.out;

import be.nicholas.api.core.error.ApiErrorDecoder;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleClientConfig {

    @Bean
    public VehicleClient vehicleClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new ApiErrorDecoder())
                .target(VehicleClient.class, "https://mysmob.api.connect.skoda-auto.cz");
    }
}
