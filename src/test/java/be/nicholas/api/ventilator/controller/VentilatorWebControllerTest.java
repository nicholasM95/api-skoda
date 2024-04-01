package be.nicholas.api.ventilator.controller;

import be.nicholas.api.core.auth.pin.PinLogin;
import be.nicholas.api.host.service.HostService;
import be.nicholas.api.ventilator.resource.out.PerformActionResponseResource;
import be.nicholas.api.ventilator.resource.out.VentilatorRequestResource;
import be.nicholas.api.ventilator.resource.out.VentilatorResponseResource;
import be.nicholas.api.ventilator.web.in.VentilatorWebController;
import be.nicholas.api.ventilator.web.out.VentilatorClient;
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

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

@WebMvcTest(VentilatorWebController.class)
@ComponentScan(basePackages = {"be.nicholas.api.ventilator"})
public class VentilatorWebControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VentilatorClient client;

    @MockBean
    private HostService hostService;

    @MockBean
    private PinLogin pinLogin;

    @Captor
    ArgumentCaptor<VentilatorRequestResource> ventilatorRequestResourceArgumentCaptor;

    @Test
    public void startVentilator() throws Exception {
        PerformActionResponseResource performActionResponseResource = new PerformActionResponseResource();
        performActionResponseResource.setRequestId("123");

        VentilatorResponseResource ventilatorResponseResource = new VentilatorResponseResource();
        ventilatorResponseResource.setPerformActionResponse(performActionResponseResource);

        URI uri = new URI("https://test.be");
        Mockito.when(hostService.getHost("QMGAG8BEQSY003476", "mal")).thenReturn(uri);
        Mockito.when(pinLogin.doPinLogin("QMGAG8BEQSY003476", "1111")).thenReturn("sec-token");
        Mockito.when(client.startVentilator(eq(uri), eq("QMGAG8BEQSY003476"), eq("sec-token"), ventilatorRequestResourceArgumentCaptor.capture())).thenReturn(ventilatorResponseResource);

        String request = """
                {
                    "duration": 30,
                    "pin": "1111"
                }""";

        String response = """
                {
                    "id":"123",
                    "vin":"QMGAG8BEQSY003476"
                }""";

        mockMvc.perform(post("/ventilator/QMGAG8BEQSY003476/start")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(header().stringValues("Location", "/request/QMGAG8BEQSY003476/123"))
                .andExpect(content().json(response, true));

        Assertions.assertEquals(ventilatorRequestResourceArgumentCaptor.getValue().getPerformAction().getQuickstart().getClimatisationDuration(), 30);
        Assertions.assertTrue(ventilatorRequestResourceArgumentCaptor.getValue().getPerformAction().getQuickstart().isActive());
    }

    @Test
    public void stopVentilator() throws Exception {
        PerformActionResponseResource performActionResponseResource = new PerformActionResponseResource();
        performActionResponseResource.setRequestId("123");

        VentilatorResponseResource ventilatorResponseResource = new VentilatorResponseResource();
        ventilatorResponseResource.setPerformActionResponse(performActionResponseResource);

        URI uri = new URI("https://test.be");
        Mockito.when(hostService.getHost("QMGAG8BEQSY003476", "mal")).thenReturn(uri);
        Mockito.when(client.stopVentilator(eq(uri), eq("QMGAG8BEQSY003476"), ventilatorRequestResourceArgumentCaptor.capture())).thenReturn(ventilatorResponseResource);

        String request = """
                {}""";
        String response = """
                {"id":"123","vin":"QMGAG8BEQSY003476"}""";

        mockMvc.perform(post("/ventilator/QMGAG8BEQSY003476/stop")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json(response, true));

        Assertions.assertFalse(ventilatorRequestResourceArgumentCaptor.getValue().getPerformAction().getQuickstop().isActive());
    }
}
