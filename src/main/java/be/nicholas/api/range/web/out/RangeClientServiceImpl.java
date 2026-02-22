package be.nicholas.api.range.web.out;

import be.nicholas.api.range.domain.Range;
import be.nicholas.api.range.resource.out.RangeResponseResource;
import be.nicholas.api.range.service.RangeClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RangeClientServiceImpl implements RangeClientService {

    private final RangeClient client;

    @Override
    public Range findRangeByVin(String vin) {
        log.info("find range for vin {}", vin);
        RangeResponseResource responseResource = client.findRangeByVin(vin);
        return new Range(responseResource.getCarType(), responseResource.getTotalRangeInKm(), responseResource.getPrimaryEngineRange().getEngineType(),
                responseResource.getPrimaryEngineRange().getCurrentSoCInPercent(), responseResource.getPrimaryEngineRange().getRemainingRangeInKm(),
                responseResource.getCarCapturedTimestamp());
    }
}
