package be.nicholas.api.statistics.web.out;

import be.nicholas.api.core.error.ApiErrorDecoder;
import be.nicholas.api.core.web.AuthInterceptor;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StatisticsClientConfig {

    @Bean
    public StatisticsClient statisticsClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new ApiErrorDecoder())
                .requestInterceptor(new AuthInterceptor())
                .target(StatisticsClient.class, "https://localhost:8080");
    }
}
