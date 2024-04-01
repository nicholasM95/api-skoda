package be.nicholas.api.role.resource.out;

import java.util.List;
import java.util.Map;

public class RoleInfoResponseResource {

    private List<Map<String, Object>> serviceInfo;

    public List<Map<String, Object>> getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(List<Map<String, Object>> serviceInfo) {
        this.serviceInfo = serviceInfo;
    }
}
