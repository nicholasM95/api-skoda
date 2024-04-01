package be.nicholas.api.statistics.service;

import be.nicholas.api.statistics.domain.Statistics;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class StatisticsService {
    private final StatisticsClientService service;

    public Statistics getStatistics(String vin) {
        log.info("get statistics for {}", vin);
        return service.getStatistics(vin);
    }
}
