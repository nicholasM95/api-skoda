package be.nicholas.api.vehicle.controller;

import be.nicholas.api.vehicle.resource.out.VehicleResponseResource;
import be.nicholas.api.vehicle.resource.out.VehicleSpecificationResponseResource;
import be.nicholas.api.vehicle.web.in.VehicleWebController;
import be.nicholas.api.vehicle.web.out.VehicleClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(VehicleWebController.class)
@ComponentScan(basePackages = {"be.nicholas.api.vehicle"})
public class VehicleWebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehicleClient client;

    @Test
    public void findAllVehicles() throws Exception {
        List<VehicleResponseResource> vehicles = new ArrayList<>();
        vehicles.add(getVehicleResponseResource());

        Mockito.when(client.getVehicles()).thenReturn(vehicles);


        String response = """
                [
                    {
                        "id": "QMGAG8BEQSY003476",
                        "vin": "QMGAG8BEQSY003476",
                        "lastUpdated": "2024-10-10T10:10:10",
                        "name": "Škoda Octavia"
                    }
                ]
                """;

        this.mockMvc.perform(get("/vehicle")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json(response, true));
    }

    private static VehicleResponseResource getVehicleResponseResource() {
        VehicleSpecificationResponseResource vehicleSpecificationResponseResource = new VehicleSpecificationResponseResource();
        vehicleSpecificationResponseResource.setTitle("Škoda Octavia");

        VehicleResponseResource vehicleResponseResource = new VehicleResponseResource();
        vehicleResponseResource.setId("QMGAG8BEQSY003476");
        vehicleResponseResource.setVin("QMGAG8BEQSY003476");
        vehicleResponseResource.setLastUpdatedAt(LocalDateTime.of(2024, 10, 10, 10, 10, 10));
        vehicleResponseResource.setSpecification(vehicleSpecificationResponseResource);
        return vehicleResponseResource;
    }
}
