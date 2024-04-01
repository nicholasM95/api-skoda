package be.nicholas.api.cooling.controller;

import be.nicholas.api.cooling.resource.out.*;
import be.nicholas.api.cooling.web.in.CoolingWebController;
import be.nicholas.api.cooling.web.out.CoolingClient;
import be.nicholas.api.host.service.HostService;
import org.checkerframework.checker.units.qual.C;
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

@WebMvcTest(CoolingWebController.class)
@ComponentScan(basePackages = {"be.nicholas.api.cooling"})
public class CoolingWebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoolingClient client;

    @MockBean
    private HostService hostService;

    @Test
    public void getCoolingStatus() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.of(2024,10,10,10,10,10);

        CoolingStateReportResponseResource coolingStateReportResponseResource = new CoolingStateReportResponseResource();
        coolingStateReportResponseResource.setClimatisationState("CLIM_STATE");
        coolingStateReportResponseResource.setClimatisationDuration(10);
        coolingStateReportResponseResource.setRemainingClimateTime(10);
        coolingStateReportResponseResource.setClimateStatusCode(10);

        CoolingTemperatureReportResponseResource coolingTemperatureReportResponseResource = new CoolingTemperatureReportResponseResource();
        coolingTemperatureReportResponseResource.setOutdoorTempValid("VALID");
        coolingTemperatureReportResponseResource.setOutdoorTemp(1234);
        coolingTemperatureReportResponseResource.setTemperatureTime(localDateTime);

        StatusResponseResource statusResponseResource = getStatusResponseResource(coolingStateReportResponseResource, coolingTemperatureReportResponseResource, localDateTime);

        CoolingResponseResource coolingResponseResource = new CoolingResponseResource();
        coolingResponseResource.setStatusResponse(statusResponseResource);

        URI uri = new URI("https://test.be");
        Mockito.when(hostService.getHost("QMGAG8BEQSY003476", "mal")).thenReturn(uri);
        Mockito.when(client.getStatus(uri, "QMGAG8BEQSY003476")).thenReturn(coolingResponseResource);

        String response = """
                {
                    "instrumentClusterTime":"2024-10-10T10:10:10",
                    "carCapturedUTCTimestamp":"2024-10-10T10:10:10",
                    "vehicleParkingClock":"2024-10-10T10:10:10",
                    "outdoorTempValid":"VALID",
                    "outdoorTemp":1234,
                    "temperatureTime":"2024-10-10T10:10:10",
                    "climatisationDuration":34,
                    "startMode":"START_MODE",
                    "heaterMode":"HEATER_MODE",
                    "report":{
                        "climatisationState":"CLIM_STATE",
                        "climatisationDuration":10,
                        "remainingClimateTime":10,
                        "climateStatusCode":10
                    },
                    "timers":[
                        {
                            "id":15,
                            "heaterMode":"HEATER_MODE",
                            "timerProgrammedStatus":true,
                            "weekday":5,
                            "hour":5,
                            "minute":5
                        }
                    ]
                }""";

        mockMvc.perform(get("/cooling/QMGAG8BEQSY003476")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json(response, true));

    }

    private static StatusResponseResource getStatusResponseResource(CoolingStateReportResponseResource coolingStateReportResponseResource, CoolingTemperatureReportResponseResource coolingTemperatureReportResponseResource, LocalDateTime localDateTime) {
        CoolingSettingsReportResponseResource coolingSettingsReportResponseResource = new CoolingSettingsReportResponseResource();
        coolingSettingsReportResponseResource.setClimatisationDuration(34);
        coolingSettingsReportResponseResource.setStartMode("START_MODE");
        coolingSettingsReportResponseResource.setHeaterMode("HEATER_MODE");

        DepartureTimersReportResponseResource departureTimersReportResponseResource = getDepartureTimersReportResponseResource();

        StatusResponseResource statusResponseResource = new StatusResponseResource();
        statusResponseResource.setClimatisationStateReport(coolingStateReportResponseResource);
        statusResponseResource.setDepartureTimersReport(departureTimersReportResponseResource);
        statusResponseResource.setClimatisationTemperatureReport(coolingTemperatureReportResponseResource);
        statusResponseResource.setClimatisationSettingsReport(coolingSettingsReportResponseResource);
        statusResponseResource.setInstrumentClusterTime(localDateTime);
        statusResponseResource.setCarCapturedUTCTimestamp(localDateTime);
        statusResponseResource.setVehicleParkingClock(localDateTime);
        return statusResponseResource;
    }

    private static DepartureTimersReportResponseResource getDepartureTimersReportResponseResource() {
        DepartureTimerResponseResource departureTimerResponseResource = getDepartureTimerResponseResource();

        List<DepartureTimerResponseResource> departureTimerResponseResourceList = new ArrayList<>();
        departureTimerResponseResourceList.add(departureTimerResponseResource);

        DepartureTimersResponseResource departureTimersResponseResource = new DepartureTimersResponseResource();
        departureTimersResponseResource.setDepartureTimer(departureTimerResponseResourceList);

        DepartureTimersReportResponseResource departureTimersReportResponseResource = new DepartureTimersReportResponseResource();
        departureTimersReportResponseResource.setDepartureTimers(departureTimersResponseResource);
        return departureTimersReportResponseResource;
    }

    private static DepartureTimerResponseResource getDepartureTimerResponseResource() {
        DepartureTimeCyclicResponseResource departureTimeCyclicResponseResource = new DepartureTimeCyclicResponseResource();
        departureTimeCyclicResponseResource.setHour(5);
        departureTimeCyclicResponseResource.setWeekdayBitmask(5);
        departureTimeCyclicResponseResource.setMinute(5);

        DepartureTimerResponseResource departureTimerResponseResource = new DepartureTimerResponseResource();
        departureTimerResponseResource.setDepartureTimeCyclic(departureTimeCyclicResponseResource);
        departureTimerResponseResource.setTimerID(15);
        departureTimerResponseResource.setTimerProgrammedStatus(true);
        return departureTimerResponseResource;
    }
}
