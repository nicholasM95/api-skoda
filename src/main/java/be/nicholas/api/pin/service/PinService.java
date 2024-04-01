package be.nicholas.api.pin.service;

import be.nicholas.api.core.auth.pin.PinLogin;
import be.nicholas.api.pin.domain.Pin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PinService implements PinLogin {
    private final PinClientService service;

    @Override
    public String doPinLogin(String vin, String pin) {
        log.info("do pin login for {}", vin);
        return service.getSecurityCode(new Pin(vin, pin));
    }
}
