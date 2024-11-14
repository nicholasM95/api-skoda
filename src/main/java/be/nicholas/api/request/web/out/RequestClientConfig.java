package be.nicholas.api.request.web.out;

import be.nicholas.api.core.error.ApiErrorDecoder;
import be.nicholas.api.core.web.AuthInterceptor;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestClientConfig {

    @Bean
    public RequestClient requestClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new ApiErrorDecoder())
                .requestInterceptor(new AuthInterceptor())
                .target(RequestClient.class, "https://localhost:8080");
    }
}
