package be.nicholas.api.cooling.mapper;

import be.nicholas.api.cooling.domain.Cooling;
import be.nicholas.api.cooling.domain.Report;
import be.nicholas.api.cooling.domain.Timer;
import be.nicholas.api.resource.CoolingWebResponseResource;
import be.nicholas.api.resource.ReportWebResponseResource;
import be.nicholas.api.resource.TimerWebResponseResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoolingMapperImpl implements CoolingMapper {
    @Override
    public CoolingWebResponseResource toWebResource(final Cooling cooling) {
        return CoolingWebResponseResource.builder()
                .instrumentClusterTime(cooling.instrumentClusterTime())
                .carCapturedUTCTimestamp(cooling.carCapturedUTCTimestamp())
                .vehicleParkingClock(cooling.vehicleParkingClock())
                .outdoorTempValid(cooling.outdoorTempValid())
                .outdoorTemp(cooling.outdoorTemp())
                .temperatureTime(cooling.temperatureTime())
                .climatisationDuration(cooling.climatisationDuration())
                .temperatureTime(cooling.temperatureTime())
                .climatisationDuration(cooling.climatisationDuration())
                .startMode(cooling.startMode())
                .heaterMode(cooling.heaterMode())
                .report(createReportWebResponseResource(cooling.report()))
                .timers(createTimersWebResponseResources(cooling.timers(), cooling.heaterMode()))
                .build();
    }

    private ReportWebResponseResource createReportWebResponseResource(final Report report) {
        return ReportWebResponseResource.builder()
                .climatisationState(report.climatisationState())
                .climatisationDuration(report.climatisationDuration())
                .remainingClimateTime(report.remainingClimateTime())
                .climateStatusCode(report.climateStatusCode())
                .build();
    }

    private List<TimerWebResponseResource> createTimersWebResponseResources(final List<Timer> timers, String mode) {
        List<TimerWebResponseResource> timersWebResponseResources = new ArrayList<>();
        for (Timer timer : timers) {
            timersWebResponseResources.add(createTimersWebResponseResource(timer, mode));
        }
        return timersWebResponseResources;
    }

    private TimerWebResponseResource createTimersWebResponseResource(final Timer timer, final String mode) {
        return TimerWebResponseResource.builder()
                .id(timer.id())
                .heaterMode(mode)
                .timerProgrammedStatus(timer.timerProgrammedStatus())
                .weekday(timer.weekday())
                .hour(timer.hour())
                .minute(timer.minute())
                .build();
    }
}
