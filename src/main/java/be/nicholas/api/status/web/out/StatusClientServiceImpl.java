package be.nicholas.api.status.web.out;

import be.nicholas.api.host.service.HostService;
import be.nicholas.api.status.domain.Data;
import be.nicholas.api.status.domain.Field;
import be.nicholas.api.status.domain.Status;
import be.nicholas.api.status.resource.out.DataResponseResource;
import be.nicholas.api.status.resource.out.FieldResponseResource;
import be.nicholas.api.status.resource.out.StatusResponseResource;
import be.nicholas.api.status.service.StatusClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class StatusClientServiceImpl implements StatusClientService {

    private static final String MODE = "mal";
    private final StatusClient client;
    private final HostService hostService;

    private List<Field> getFields(List<FieldResponseResource> fields) {
        return fields.stream().map(this::getField).collect(Collectors.toList());
    }

    private List<Data> getData(List<DataResponseResource> data) {
        return data.stream().map(this::getData).collect(Collectors.toList());

    }

    private Field getField(FieldResponseResource field) {
        return new Field(field.getId(), field.getTsCarSentUtc(), field.getTsCarSent(), field.getTsTssReceivedUtc(),
                field.getTsTssReceivedUtc(), field.getMilCarCaptured(), field.getMilCarSent(), field.getValue(), field.getUnit(),
                field.getTextId(), field.getPicId());
    }

    private Data getData(DataResponseResource data) {
        return new Data(data.getId(), getFields(data.getField()));
    }

    @Override
    public Status getStatusByVin(String vin) {
        log.info("get status for vin {}", vin);
        URI uri = hostService.getHost(vin, MODE);
        StatusResponseResource response = client.getStatus(uri, vin);
        return new Status(response.getStoredVehicleDataResponse().getVin(), getData(response.getStoredVehicleDataResponse().getVehicleData().getData()));
    }
}
