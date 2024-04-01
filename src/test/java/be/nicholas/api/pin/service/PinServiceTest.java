package be.nicholas.api.pin.service;

import be.nicholas.api.pin.resource.out.*;
import be.nicholas.api.pin.web.out.PinClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PinServiceTest {
    @Autowired
    private PinService pinService;

    @MockBean
    private PinClient client;

    @Captor
    ArgumentCaptor<PinRequestResource> pinRequestResourceArgumentCaptor;

    @Test
    public void pinLogin() {
        PinResponseResource pinResponseResource = getPinResponseResource();
        Mockito.when(client.prepareLogin("QMGAG8BEQSY003476")).thenReturn(pinResponseResource);

        TokenResponseResource tokenResponseResource = new TokenResponseResource();
        tokenResponseResource.setSecurityToken("sec-token");
        Mockito.when(client.doLogin(pinRequestResourceArgumentCaptor.capture())).thenReturn(tokenResponseResource);

        String token = pinService.doPinLogin("QMGAG8BEQSY003476", "1111");
        Assertions.assertEquals("sec-token", token);

        Assertions.assertEquals("challenge1", pinRequestResourceArgumentCaptor.getValue().getSecurityPinAuthentication().getSecurityPin().getChallenge());
        Assertions.assertEquals("c6945abb2d803467bdf6b1e7bb22a10e38faf4f3878a8c2484abe6c06fd31b20a8a1b7181a8e16232cdc67791cdf367ac0db37b495a6785b253fec556e2d1eb5", pinRequestResourceArgumentCaptor.getValue().getSecurityPinAuthentication().getSecurityPin().getSecurityPinHash());
    }

    private static PinResponseResource getPinResponseResource() {
        PinTransmissionResponseResource pinTransmissionResponseResource = new PinTransmissionResponseResource();
        pinTransmissionResponseResource.setChallenge("challenge1");

        PinAuthInfoResponseResource pinAuthInfoResponseResource = new PinAuthInfoResponseResource();
        pinAuthInfoResponseResource.setSecurityPinTransmission(pinTransmissionResponseResource);

        PinResponseResource pinResponseResource = new PinResponseResource();
        pinResponseResource.setSecurityPinAuthInfo(pinAuthInfoResponseResource);
        return pinResponseResource;
    }
}
