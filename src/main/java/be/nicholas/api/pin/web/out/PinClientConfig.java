package be.nicholas.api.pin.web.out;

import be.nicholas.api.core.web.AuthInterceptor;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PinClientConfig {

    @Bean
    public PinClient pinClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AuthInterceptor())
                .target(PinClient.class, "https://mal-3a.prd.eu.dp.vwg-connect.com");
    }
}
