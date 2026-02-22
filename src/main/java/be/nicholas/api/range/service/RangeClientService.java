package be.nicholas.api.range.service;

import be.nicholas.api.range.domain.Range;

public interface RangeClientService {

    Range findRangeByVin(String vin);
}
