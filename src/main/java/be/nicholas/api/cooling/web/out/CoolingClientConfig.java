package be.nicholas.api.cooling.web.out;

import be.nicholas.api.core.error.ApiErrorDecoder;
import be.nicholas.api.core.web.AuthInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoolingClientConfig {

    @Bean
    public CoolingClient coolingClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder(createObjectMapper()))
                .errorDecoder(new ApiErrorDecoder())
                .requestInterceptor(new AuthInterceptor())
                .target(CoolingClient.class, "https://localhost:8080");
    }

    private static ObjectMapper createObjectMapper() {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
}
