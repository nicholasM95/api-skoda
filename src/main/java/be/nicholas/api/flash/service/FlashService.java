package be.nicholas.api.flash.service;

import be.nicholas.api.flash.domain.Flash;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class FlashService {
    private final FlashClientService service;

    public Flash flash(String vin, int latitude, int longitude, int duration) {
        log.info("flash for {} with duration {}", vin, duration);
        Flash flash = new Flash(vin, latitude, longitude, duration, null, null, null, null);
        return service.flash(flash);
    }
}
