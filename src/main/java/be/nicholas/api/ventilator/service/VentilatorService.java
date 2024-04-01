package be.nicholas.api.ventilator.service;

import be.nicholas.api.ventilator.domain.Ventilator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class VentilatorService {
   private final VentilatorClientService service;

    public Ventilator startVentilator(String vin, String pin, int duration) {
        log.info("start ventilator for {} with duration of {}", vin, duration);
        return service.startVentilator(new Ventilator(vin, pin, duration, null));
    }

    public Ventilator stopVentilator(String vin) {
        log.info("stop ventilator for {}", vin);
        return service.stopVentilator(new Ventilator(vin, null, 0, null));
    }
}
