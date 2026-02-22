package be.nicholas.api.range.web.in;

import be.nicholas.api.controller.RangeApi;
import be.nicholas.api.range.mapper.RangeMapper;
import be.nicholas.api.range.service.RangeService;
import be.nicholas.api.resource.RangeWebResponseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RangeWebController implements RangeApi {

    private final RangeMapper mapper;
    private final RangeService service;


    @Override
    public ResponseEntity<RangeWebResponseResource> getRange(String vin) {
        return ResponseEntity.ok(mapper.toWebResource(service.findRangeByVin(vin)));
    }
}
