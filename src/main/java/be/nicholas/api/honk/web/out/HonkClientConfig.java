package be.nicholas.api.honk.web.out;

import be.nicholas.api.core.web.AuthInterceptor;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HonkClientConfig {
    @Bean
    public HonkClient honkClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AuthInterceptor())
                .target(HonkClient.class, "https://localhost:8080");
    }
}
