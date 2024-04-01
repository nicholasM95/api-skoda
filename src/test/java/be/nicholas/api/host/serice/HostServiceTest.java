package be.nicholas.api.host.serice;

import be.nicholas.api.host.resource.out.BaseUriResponseResource;
import be.nicholas.api.host.resource.out.HostResponseResource;
import be.nicholas.api.host.resource.out.UriResponseResource;
import be.nicholas.api.host.service.HostService;
import be.nicholas.api.host.web.out.HostClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.net.URI;

@SpringBootTest
public class HostServiceTest {
    @Autowired
    private HostService hostService;

    @MockBean
    private HostClient client;

    @Test
    public void getHotFal() {
        BaseUriResponseResource baseUriResponseResource = new BaseUriResponseResource();
        baseUriResponseResource.setContent("CONTENT");
        baseUriResponseResource.setSystemId("SYSTEM_ID");

        UriResponseResource uriResponseResource = new UriResponseResource();
        uriResponseResource.setBaseUri(baseUriResponseResource);

        HostResponseResource hostResponseResource = new HostResponseResource();
        hostResponseResource.setHomeRegion(uriResponseResource);

        Mockito.when(client.getHomeRegion("QMGAG8BEQSY003476")).thenReturn(hostResponseResource);

        URI result = hostService.getHost("QMGAG8BEQSY003476", "fal");

        Assertions.assertEquals("CONTENT", result.toString());
    }

    @Test
    public void getHotMal() {
        BaseUriResponseResource baseUriResponseResource = new BaseUriResponseResource();
        baseUriResponseResource.setContent("CONTENT");
        baseUriResponseResource.setSystemId("SYSTEM_ID");

        UriResponseResource uriResponseResource = new UriResponseResource();
        uriResponseResource.setBaseUri(baseUriResponseResource);

        HostResponseResource hostResponseResource = new HostResponseResource();
        hostResponseResource.setHomeRegion(uriResponseResource);

        Mockito.when(client.getHomeRegion("QMGAG8BEQSY003476")).thenReturn(hostResponseResource);

        URI result = hostService.getHost("QMGAG8BEQSY003476", "mal");

        Assertions.assertEquals("CONTENT", result.toString());
    }
}
