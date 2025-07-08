package be.nicholas.api.status.mapper;

import be.nicholas.api.resource.DataWebResponseResource;
import be.nicholas.api.resource.FieldWebResponseResource;
import be.nicholas.api.resource.StatusWebResponseResource;
import be.nicholas.api.status.domain.Data;
import be.nicholas.api.status.domain.Field;
import be.nicholas.api.status.domain.Status;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StatusMapperImpl implements StatusMapper {
    @Override
    public StatusWebResponseResource toWebResource(final Status status) {
        return StatusWebResponseResource.builder()
                .vin(status.vin())
                .data(createDataWebResponseResources(status.data()))
                .build();
    }

    private List<DataWebResponseResource> createDataWebResponseResources(final List<Data> data) {
        List<DataWebResponseResource> dataWebResponseResources = new ArrayList<>();
        for (Data d : data) {
            dataWebResponseResources.add(createDataWebResponseResource(d));
        }
        return dataWebResponseResources;
    }

    private DataWebResponseResource createDataWebResponseResource(final Data data) {
        return DataWebResponseResource.builder()
                .id(data.id())
                .fields(createFields(data.fields()))
                .build();
    }

    private List<FieldWebResponseResource> createFields(final List<Field> fields) {
        List<FieldWebResponseResource> fieldWebResponseResources = new ArrayList<>();
        for (Field field : fields) {
            fieldWebResponseResources.add(createField(field));
        }
        return fieldWebResponseResources;
    }

    private FieldWebResponseResource createField(final Field field) {
        return FieldWebResponseResource.builder()
                .id(field.id())
                .tsCarSentUtc(field.tsCarSentUtc())
                .tsCarSent(field.tsCarSent())
                .tsCarCaptured(field.tsCarCaptured())
                .tsTssReceivedUtc(field.tsTssReceivedUtc())
                .milCarCaptured(field.milCarCaptured())
                .milCarSent(field.milCarSent())
                .value(field.value())
                .unit(field.unit())
                .textId(field.textId())
                .picId(field.picId())
                .build();
    }
}
