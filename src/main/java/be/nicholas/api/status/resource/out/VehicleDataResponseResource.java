package be.nicholas.api.status.resource.out;

import java.util.List;

public class VehicleDataResponseResource {
    private List<DataResponseResource> data;

    public List<DataResponseResource> getData() {
        return data;
    }

    public void setData(List<DataResponseResource> data) {
        this.data = data;
    }
}
