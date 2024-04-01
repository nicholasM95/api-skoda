package be.nicholas.api.statistics.web.out;

import be.nicholas.api.host.service.HostService;
import be.nicholas.api.statistics.domain.Statistics;
import be.nicholas.api.statistics.resource.out.StatisticsResponseResource;
import be.nicholas.api.statistics.service.StatisticsClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@Service
public class StatisticsClientServiceImpl implements StatisticsClientService {

    private static final String MODE = "mal";
    private final StatisticsClient client;
    private final HostService hostService;

    @Override
    public Statistics getStatistics(String vin) {
        log.info("get statistics for vin {}", vin);
        URI uri = hostService.getHost(vin, MODE);
        StatisticsResponseResource response = client.getStatistics(uri, vin);

        int overallMileage = Integer.parseInt(response.getTripData().getOverallMileage());
        int averageFuelConsumption = Integer.parseInt(response.getTripData().getAverageFuelConsumption());
        int travelTime = Integer.parseInt(response.getTripData().getTraveltime());
        int startMileage = Integer.parseInt(response.getTripData().getStartMileage());
        int averageSpeed = Integer.parseInt(response.getTripData().getAverageSpeed());
        int mileage = Integer.parseInt(response.getTripData().getMileage());

        return new Statistics(overallMileage, response.getTripData().getTripType(), averageFuelConsumption,
                travelTime, startMileage, response.getTripData().getTripID(),
                averageSpeed, mileage, response.getTripData().getTimestamp(),
                response.getTripData().getReportReason());
    }
}
