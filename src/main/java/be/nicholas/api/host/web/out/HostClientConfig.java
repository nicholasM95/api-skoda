package be.nicholas.api.host.web.out;

import be.nicholas.api.core.web.AuthInterceptor;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HostClientConfig {

    @Bean
    public HostClient hostClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(new AuthInterceptor())
                .target(HostClient.class, "https://mal-1a.prd.ece.vwg-connect.com");
    }
}
