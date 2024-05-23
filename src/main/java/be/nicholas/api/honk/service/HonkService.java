package be.nicholas.api.honk.service;

import be.nicholas.api.honk.domain.Honk;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class HonkService {
    private final HonkClientService service;

    public Honk honk(String vin, int latitude, int longitude, int duration) {
        log.info("honk for {} with duration {}", vin, duration);
        Honk honk = new Honk(vin, latitude, longitude, duration, null, null, null, null);
        return service.honk(honk);
    }
}
