package be.nicholas.api.location.controller;

import be.nicholas.api.host.service.HostService;
import be.nicholas.api.location.resource.out.LocationInfoResponseResource;
import be.nicholas.api.location.resource.out.LocationResponseResource;
import be.nicholas.api.location.resource.out.ParkResponseResource;
import be.nicholas.api.location.resource.out.PositionResponseResource;
import be.nicholas.api.location.web.in.LocationWebController;
import be.nicholas.api.location.web.out.LocationClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(LocationWebController.class)
@ComponentScan(basePackages = {"be.nicholas.api.location"})
public class LocationWebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationClient client;

    @MockBean
    private HostService hostService;

    @Test
    public void getLocation() throws Exception {
        LocationResponseResource locationResponseResource = getLocationResponseResource();

        URI uri = new URI("https://test.be");
        Mockito.when(hostService.getHost("QMGAG8BEQSY003476", "mal")).thenReturn(uri);
        Mockito.when(client.findPositionByVin(uri, "QMGAG8BEQSY003476")).thenReturn(locationResponseResource);

        String response = """
                {"latitude":123,"longitude":456,"parkingTime":"2024-10-10T10:10:00"}""";

        mockMvc.perform(get("/location/QMGAG8BEQSY003476")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json(response, true));
    }

    private static LocationResponseResource getLocationResponseResource() {
        PositionResponseResource positionResponseResource = new PositionResponseResource();
        positionResponseResource.setLatitude(123);
        positionResponseResource.setLongitude(456);

        LocationInfoResponseResource locationInfoResponseResource = new LocationInfoResponseResource();
        locationInfoResponseResource.setCarCoordinate(positionResponseResource);

        ParkResponseResource parkResponseResource = new ParkResponseResource();
        parkResponseResource.setPosition(locationInfoResponseResource);
        parkResponseResource.setParkingTimeUTC(LocalDateTime.of(2024, 10, 10, 10, 10));

        LocationResponseResource locationResponseResource = new LocationResponseResource();
        locationResponseResource.setFindCarResponse(parkResponseResource);
        return locationResponseResource;
    }
}
