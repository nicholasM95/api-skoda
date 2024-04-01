package be.nicholas.api.statistics.web.in;

import be.nicholas.api.controller.StatisticsApi;
import be.nicholas.api.resource.StatisticsWebResponseResource;
import be.nicholas.api.statistics.domain.Statistics;
import be.nicholas.api.statistics.mapper.StatisticsMapper;
import be.nicholas.api.statistics.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StatisticsWebController implements StatisticsApi {

    private final StatisticsService service;
    private final StatisticsMapper mapper;

    @Override
    public ResponseEntity<StatisticsWebResponseResource> getStatistics(String vin) {
        Statistics statistics = service.getStatistics(vin);
        return ResponseEntity.ok(mapper.toWebResource(statistics));
    }
}
