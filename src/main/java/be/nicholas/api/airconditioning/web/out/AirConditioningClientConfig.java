package be.nicholas.api.airconditioning.web.out;

import be.nicholas.api.core.error.ApiErrorDecoder;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AirConditioningClientConfig {

    @Bean
    public AirConditioningClient airConditioningClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new ApiErrorDecoder())
                .target(AirConditioningClient.class, "https://mysmob.api.connect.skoda-auto.cz");
    }
}
