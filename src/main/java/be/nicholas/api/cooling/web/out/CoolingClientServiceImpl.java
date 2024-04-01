package be.nicholas.api.cooling.web.out;

import be.nicholas.api.cooling.domain.Cooling;
import be.nicholas.api.cooling.domain.Report;
import be.nicholas.api.cooling.domain.Timer;
import be.nicholas.api.cooling.resource.out.CoolingResponseResource;
import be.nicholas.api.cooling.resource.out.CoolingStateReportResponseResource;
import be.nicholas.api.cooling.resource.out.DepartureTimerResponseResource;
import be.nicholas.api.cooling.service.CoolingClientService;
import be.nicholas.api.core.host.FindHostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CoolingClientServiceImpl implements CoolingClientService {
    private static final String MODE = "mal";
    private final CoolingClient client;
    private final FindHostService hostService;

    private static Report getReport(CoolingStateReportResponseResource resource) {
        String climatisationState = resource.getClimatisationState();
        int climatisationDuration = resource.getClimatisationDuration();
        int remainingClimateTime = resource.getRemainingClimateTime();
        int climateStatusCode = resource.getClimateStatusCode();
        return new Report(climatisationState, climatisationDuration, remainingClimateTime, climateStatusCode);
    }

    @Override
    public Cooling getCoolingByVin(String vin) {
        URI uri = hostService.getHost(vin, MODE);
        CoolingResponseResource response = client.getStatus(uri, vin);

        Report report = getReport(response.getStatusResponse().getClimatisationStateReport());
        List<Timer> timers = response.getStatusResponse().getDepartureTimersReport().getDepartureTimers().getDepartureTimer().stream().map(this::getTimer).toList();

        LocalDateTime instrumentClusterTime = response.getStatusResponse().getInstrumentClusterTime();
        LocalDateTime carCapturedUTCTimestamp = response.getStatusResponse().getCarCapturedUTCTimestamp();
        LocalDateTime vehicleParkingClock = response.getStatusResponse().getVehicleParkingClock();
        String outdoorTempValid = response.getStatusResponse().getClimatisationTemperatureReport().getOutdoorTempValid();
        int outdoorTemp = response.getStatusResponse().getClimatisationTemperatureReport().getOutdoorTemp();
        LocalDateTime temperatureTime = response.getStatusResponse().getClimatisationTemperatureReport().getTemperatureTime();
        int climatisationDuration = response.getStatusResponse().getClimatisationSettingsReport().getClimatisationDuration();
        String startMode = response.getStatusResponse().getClimatisationSettingsReport().getStartMode();
        String heaterMode = response.getStatusResponse().getClimatisationSettingsReport().getHeaterMode();

        return new Cooling(instrumentClusterTime, carCapturedUTCTimestamp, vehicleParkingClock, outdoorTempValid,
                outdoorTemp, temperatureTime, climatisationDuration, startMode, heaterMode, report, timers);
    }

    private Timer getTimer(DepartureTimerResponseResource resource) {
        int id = resource.getTimerID();
        boolean timerProgrammedStatus = resource.isTimerProgrammedStatus();
        int weekday = resource.getDepartureTimeCyclic().getWeekdayBitmask();
        int hour = resource.getDepartureTimeCyclic().getHour();
        int minute = resource.getDepartureTimeCyclic().getMinute();
        return new Timer(id, timerProgrammedStatus, weekday, hour, minute);
    }
}
