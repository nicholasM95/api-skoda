package be.nicholas.api.pin.web.out;

import be.nicholas.api.pin.domain.Pin;
import be.nicholas.api.pin.resource.out.*;
import be.nicholas.api.pin.service.PinClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PinClientServiceImpl implements PinClientService {

    private final PinClient client;

    private static SecurityPinRequestResource createSecurityPin(String challenge, String pin) {
        SecurityPinRequestResource securityPin = new SecurityPinRequestResource();
        securityPin.setChallenge(challenge);
        securityPin.setSecurityPinHash(createPinHash(pin + challenge));
        return securityPin;
    }

    private static String createPinHash(String input) {
        return DigestUtils.sha512Hex(hexStringToByteArray(input));
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    private static PinAuthenticationRequestResource createSecurityPinAuthentication(SecurityPinRequestResource securityPin, String token) {
        PinAuthenticationRequestResource securityPinAuthentication = new PinAuthenticationRequestResource();
        securityPinAuthentication.setSecurityPin(securityPin);
        securityPinAuthentication.setSecurityToken(token);
        return securityPinAuthentication;
    }

    private PinRequestResource createPinAuthResource(PinAuthenticationRequestResource securityPinAuthentication) {
        PinRequestResource pinRequestResource = new PinRequestResource();
        pinRequestResource.setSecurityPinAuthentication(securityPinAuthentication);
        return pinRequestResource;
    }

    @Override
    public String getSecurityCode(Pin pin) {
        log.info("get security code by pin for vin {}", pin.vin());
        PinResponseResource pinResponse = client.prepareLogin(pin.vin());
        SecurityPinRequestResource pinRequest =
                createSecurityPin(pinResponse.getSecurityPinAuthInfo().getSecurityPinTransmission().getChallenge(), pin.pin());

        PinAuthenticationRequestResource authenticationRequest = createSecurityPinAuthentication(pinRequest,
                pinResponse.getSecurityPinAuthInfo().getSecurityToken());

        PinRequestResource request = createPinAuthResource(authenticationRequest);
        TokenResponseResource response = client.doLogin(request);
        return response.getSecurityToken();
    }
}
