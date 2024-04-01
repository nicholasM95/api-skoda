package be.nicholas.api.statistics.service;

import be.nicholas.api.statistics.domain.Statistics;

public interface StatisticsClientService {

    Statistics getStatistics(String vin);
}
