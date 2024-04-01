package be.nicholas.api.statistics;

import be.nicholas.api.host.service.HostService;
import be.nicholas.api.statistics.resource.out.StatisticsResponseResource;
import be.nicholas.api.statistics.resource.out.TripDataResponseResource;
import be.nicholas.api.statistics.web.in.StatisticsWebController;
import be.nicholas.api.statistics.web.out.StatisticsClient;
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

@WebMvcTest(StatisticsWebController.class)
@ComponentScan(basePackages = {"be.nicholas.api.statistics"})
public class StatisticsWebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatisticsClient client;

    @MockBean
    private HostService hostService;

    @Test
    public void getStatistics() throws Exception {
        StatisticsResponseResource statisticsResponseResource = getStatisticsResponseResource();

        URI uri = new URI("https://test.be");
        Mockito.when(hostService.getHost("QMGAG8BEQSY003476", "mal")).thenReturn(uri);
        Mockito.when(client.getStatistics(uri, "QMGAG8BEQSY003476")).thenReturn(statisticsResponseResource);

        String response = """
                {
                    "overallMileage":123,
                    "tripType":"TRIP_TYPE",
                    "averageFuelConsumption":123,
                    "travelTime":123,
                    "startMileage":123,
                    "tripId":"TRIP_ID",
                    "averageSpeed":123,
                    "mileage":123,
                    "timestamp":"2024-10-10T10:10:10",
                    "reportReason":"REPORT_REASON"
                }
                """;

        mockMvc.perform(get("/statistics/QMGAG8BEQSY003476")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json(response, true));
    }

    private static StatisticsResponseResource getStatisticsResponseResource() {
        TripDataResponseResource tripDataResponseResource = new TripDataResponseResource();
        tripDataResponseResource.setOverallMileage("123");
        tripDataResponseResource.setAverageFuelConsumption("123");
        tripDataResponseResource.setTraveltime("123");
        tripDataResponseResource.setStartMileage("123");
        tripDataResponseResource.setAverageSpeed("123");
        tripDataResponseResource.setMileage("123");
        tripDataResponseResource.setTripType("TRIP_TYPE");
        tripDataResponseResource.setTripID("TRIP_ID");
        tripDataResponseResource.setTimestamp(LocalDateTime.of(2024,10,10,10,10,10));
        tripDataResponseResource.setReportReason("REPORT_REASON");

        StatisticsResponseResource statisticsResponseResource = new StatisticsResponseResource();
        statisticsResponseResource.setTripData(tripDataResponseResource);
        return statisticsResponseResource;
    }
}
