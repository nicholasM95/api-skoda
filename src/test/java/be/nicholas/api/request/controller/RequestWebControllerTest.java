package be.nicholas.api.request.controller;

import be.nicholas.api.host.service.HostService;
import be.nicholas.api.request.resource.out.RequestResponseResource;
import be.nicholas.api.request.resource.out.RequestStatusResponseResource;
import be.nicholas.api.request.web.in.RequestWebController;
import be.nicholas.api.request.web.out.RequestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(RequestWebController.class)
@ComponentScan(basePackages = {"be.nicholas.api.request"})
public class RequestWebControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RequestClient client;

    @MockBean
    private HostService hostService;

    @Test
    public void getRequest() throws Exception {
        RequestStatusResponseResource requestStatusResponseResource = new RequestStatusResponseResource();
        requestStatusResponseResource.setVin("QMGAG8BEQSY003476");
        requestStatusResponseResource.setStatus("OK");

        RequestResponseResource requestResponseResource = new RequestResponseResource();
        requestResponseResource.setRequestStatusResponse(requestStatusResponseResource);

        URI uri = new URI("https://test.be");
        Mockito.when(hostService.getHost("QMGAG8BEQSY003476", "mal")).thenReturn(uri);
        Mockito.when(client.getRequestStatus(uri, "QMGAG8BEQSY003476", "123"))
                .thenReturn(requestResponseResource);

        String response = """
                {"vin":"QMGAG8BEQSY003476","status":"OK"}""";

        mockMvc.perform(get("/request/QMGAG8BEQSY003476/123")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json(response, true));
    }
}
