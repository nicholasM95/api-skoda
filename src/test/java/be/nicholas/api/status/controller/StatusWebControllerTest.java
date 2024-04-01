package be.nicholas.api.status.controller;

import be.nicholas.api.status.resource.out.*;
import be.nicholas.api.host.service.HostService;
import be.nicholas.api.status.web.in.StatusWebController;
import be.nicholas.api.status.web.out.StatusClient;
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
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(StatusWebController.class)
@ComponentScan(basePackages = {"be.nicholas.api.status"})
public class StatusWebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatusClient client;

    @MockBean
    private HostService hostService;

    @Test
    public void getStatus() throws Exception {
        StatusResponseResource statusResponseResource = getStatusResponseResource();

        URI uri = new URI("https://test.be");
        Mockito.when(hostService.getHost("QMGAG8BEQSY003476", "mal")).thenReturn(uri);
        Mockito.when(client.getStatus(uri, "QMGAG8BEQSY003476")).thenReturn(statusResponseResource);

        String response = """
                {
                     "vin":"QMGAG8BEQSY003476",
                     "data":[
                        {
                            "id":"13",
                            "fields":[
                                {
                                    "id":"45",
                                    "tsCarSentUtc":"2024-10-10T10:10:00",
                                    "tsCarSent":"2024-10-10T10:10:00",
                                    "tsCarCaptured":"2024-10-10T10:10:00",
                                    "tsTssReceivedUtc":"2024-10-10T10:10:00",
                                    "milCarCaptured":4,
                                    "milCarSent":6,
                                    "value":"VAL",
                                    "unit":"UNIT",
                                    "textId":"text"
                                }
                            ]
                        }
                     ]}""";

        mockMvc.perform(get("/status/QMGAG8BEQSY003476")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json(response, true));
    }

    private static StatusResponseResource getStatusResponseResource() {
        List<DataResponseResource> dataResponseResourceList = getDataResponseResources();

        VehicleDataResponseResource vehicleDataResponseResource = new VehicleDataResponseResource();
        vehicleDataResponseResource.setData(dataResponseResourceList);

        VehicleResponseResource vehicleResponseResource = new VehicleResponseResource();
        vehicleResponseResource.setVehicleData(vehicleDataResponseResource);
        vehicleResponseResource.setVin("QMGAG8BEQSY003476");

        StatusResponseResource statusResponseResource = new StatusResponseResource();
        statusResponseResource.setStoredVehicleDataResponse(vehicleResponseResource);
        return statusResponseResource;
    }

    private static List<DataResponseResource> getDataResponseResources() {
        LocalDateTime localDateTime = LocalDateTime.of(2024, 10, 10, 10, 10);
        List<FieldResponseResource> fieldResponseResourceList = new ArrayList<>();
        FieldResponseResource fieldResponseResource = getFieldResponseResource(localDateTime);
        fieldResponseResourceList.add(fieldResponseResource);

        List<DataResponseResource> dataResponseResourceList = new ArrayList<>();
        DataResponseResource dataResponseResource = new DataResponseResource();
        dataResponseResource.setId("13");
        dataResponseResource.setField(fieldResponseResourceList);

        dataResponseResourceList.add(dataResponseResource);
        return dataResponseResourceList;
    }

    private static FieldResponseResource getFieldResponseResource(LocalDateTime localDateTime) {
        FieldResponseResource fieldResponseResource = new FieldResponseResource();
        fieldResponseResource.setId("45");
        fieldResponseResource.setTsCarSentUtc(localDateTime);
        fieldResponseResource.setTsCarSent(localDateTime);
        fieldResponseResource.setTsCarCaptured(localDateTime);
        fieldResponseResource.setTsTssReceivedUtc(localDateTime);
        fieldResponseResource.setMilCarCaptured(4);
        fieldResponseResource.setMilCarSent(6);
        fieldResponseResource.setValue("VAL");
        fieldResponseResource.setUnit("UNIT");
        fieldResponseResource.setTextId("text");
        return fieldResponseResource;
    }
}
