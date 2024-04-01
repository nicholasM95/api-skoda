package be.nicholas.api.cooling.service;

import be.nicholas.api.cooling.domain.Cooling;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class CoolingService {
    private final CoolingClientService service;

    public Cooling getCooling(String vin) {
        log.info("Get cooling info for {}", vin);
        return service.getCoolingByVin(vin);
    }
}
