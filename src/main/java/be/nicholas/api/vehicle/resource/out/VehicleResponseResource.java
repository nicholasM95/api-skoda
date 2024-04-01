package be.nicholas.api.vehicle.resource.out;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class VehicleResponseResource {
    private String id;
    private String vin;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime lastUpdatedAt;
    private VehicleSpecificationResponseResource specification;
    private List<VehicleConnectivityResponseResource> connectivities;
    private List<Map<String, Object>> capabilities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public VehicleSpecificationResponseResource getSpecification() {
        return specification;
    }

    public void setSpecification(VehicleSpecificationResponseResource specification) {
        this.specification = specification;
    }

    public List<VehicleConnectivityResponseResource> getConnectivities() {
        return connectivities;
    }

    public void setConnectivities(List<VehicleConnectivityResponseResource> connectivities) {
        this.connectivities = connectivities;
    }

    public List<Map<String, Object>> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<Map<String, Object>> capabilities) {
        this.capabilities = capabilities;
    }
}
