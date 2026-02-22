package be.nicholas.api.range.service;

import be.nicholas.api.range.domain.Range;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RangeService {
    private final RangeClientService service;

    public Range findRangeByVin(String vin) {
        return service.findRangeByVin(vin);
    }
}
