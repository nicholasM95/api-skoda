package be.nicholas.api.flash.controller;

import be.nicholas.api.flash.resource.out.FlashCommandResponseResource;
import be.nicholas.api.flash.resource.out.FlashRequestResource;
import be.nicholas.api.flash.resource.out.FlashResponseResource;
import be.nicholas.api.flash.resource.out.StatusResponseResource;
import be.nicholas.api.flash.web.in.FlashWebController;
import be.nicholas.api.flash.web.out.FlashClient;
import be.nicholas.api.host.service.HostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

@WebMvcTest(FlashWebController.class)
@ComponentScan(basePackages = {"be.nicholas.api.flash"})
public class FlashWebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlashClient client;

    @MockBean
    private HostService hostService;

    @Captor
    ArgumentCaptor<FlashRequestResource> flashRequestResourceArgumentCaptor;

    @Test
    public void flash() throws Exception {
        StatusResponseResource statusResponseResource = new StatusResponseResource();
        statusResponseResource.setStatusCode("OK");

        FlashCommandResponseResource flashCommandResponseResource = new FlashCommandResponseResource();
        flashCommandResponseResource.setId("123");
        flashCommandResponseResource.setStatus(statusResponseResource);
        flashCommandResponseResource.setLastUpdated(LocalDateTime.of(2024, 10, 10, 10, 10));

        FlashResponseResource flashResponseResource = new FlashResponseResource();
        flashResponseResource.setHonkAndFlashRequest(flashCommandResponseResource);

        URI uri = new URI("https://test.be");
        Mockito.when(hostService.getHost("QMGAG8BEQSY003476", "mal")).thenReturn(uri);
        Mockito.when(client.flash(eq(uri), eq("QMGAG8BEQSY003476"), flashRequestResourceArgumentCaptor.capture())).thenReturn(flashResponseResource);

        String request = """
                {
                    "latitude": 234,
                    "longitude": 567,
                    "duration": 10
                }""";

        String response = """
                {
                    "id":"123",
                    "status":"OK",
                    "duration":10,
                    "lastUpdated":"2024-10-10T10:10:00"
                }""";

        mockMvc.perform(post("/flash/QMGAG8BEQSY003476")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(header().stringValues("Location", "/request/QMGAG8BEQSY003476/123"))
                .andExpect(content().json(response, true));

        Assertions.assertEquals(10, flashRequestResourceArgumentCaptor.getValue().getHonkAndFlashRequest().getServiceDuration());
        Assertions.assertEquals(234, flashRequestResourceArgumentCaptor.getValue().getHonkAndFlashRequest().getUserPosition().getLatitude());
        Assertions.assertEquals(567, flashRequestResourceArgumentCaptor.getValue().getHonkAndFlashRequest().getUserPosition().getLongitude());
        Assertions.assertEquals("FLASH_ONLY", flashRequestResourceArgumentCaptor.getValue().getHonkAndFlashRequest().getServiceOperationCode());

    }
}
