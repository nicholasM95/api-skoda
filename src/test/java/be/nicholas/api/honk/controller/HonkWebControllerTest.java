package be.nicholas.api.honk.controller;

import be.nicholas.api.honk.resource.out.HonkCommandResponseResource;
import be.nicholas.api.honk.resource.out.HonkRequestResource;
import be.nicholas.api.honk.resource.out.HonkResponseResource;
import be.nicholas.api.honk.resource.out.StatusResponseResource;
import be.nicholas.api.honk.web.in.HonkWebController;
import be.nicholas.api.honk.web.out.HonkClient;
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

@WebMvcTest(HonkWebController.class)
@ComponentScan(basePackages = {"be.nicholas.api.honk"})
public class HonkWebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HonkClient client;

    @MockBean
    private HostService hostService;

    @Captor
    ArgumentCaptor<HonkRequestResource> honkRequestResourceArgumentCaptor;

    @Test
    public void honk() throws Exception {
        StatusResponseResource statusResponseResource = new StatusResponseResource();
        statusResponseResource.setStatusCode("OK");

        HonkCommandResponseResource flashCommandResponseResource = new HonkCommandResponseResource();
        flashCommandResponseResource.setId("123");
        flashCommandResponseResource.setStatus(statusResponseResource);
        flashCommandResponseResource.setLastUpdated(LocalDateTime.of(2024, 10, 10, 10, 10));

        HonkResponseResource honkResponseResource = new HonkResponseResource();
        honkResponseResource.setHonkAndFlashRequest(flashCommandResponseResource);

        URI uri = new URI("https://test.be");
        Mockito.when(hostService.getHost("QMGAG8BEQSY003476", "mal")).thenReturn(uri);
        Mockito.when(client.honk(eq(uri), eq("QMGAG8BEQSY003476"), honkRequestResourceArgumentCaptor.capture())).thenReturn(honkResponseResource);

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

        mockMvc.perform(post("/honk/QMGAG8BEQSY003476")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(header().stringValues("Location", "/request/QMGAG8BEQSY003476/123"))
                .andExpect(content().json(response, true));

        Assertions.assertEquals(10, honkRequestResourceArgumentCaptor.getValue().getHonkAndFlashRequest().getServiceDuration());
        Assertions.assertEquals(234, honkRequestResourceArgumentCaptor.getValue().getHonkAndFlashRequest().getUserPosition().getLatitude());
        Assertions.assertEquals(567, honkRequestResourceArgumentCaptor.getValue().getHonkAndFlashRequest().getUserPosition().getLongitude());
        Assertions.assertEquals("HONK_AND_FLASH", honkRequestResourceArgumentCaptor.getValue().getHonkAndFlashRequest().getServiceOperationCode());

    }
}
