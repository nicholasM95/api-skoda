package be.nicholas.api.cache;

import be.nicholas.api.host.domain.Host;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HostCache {
    private final Map<String, Host> hosts;

    public HostCache() {
        this.hosts = new HashMap<>();
    }

    public void addHost(String vin, String mode, Host host) {
        this.hosts.put(vin + mode, host);
    }

    public boolean isCached(String vin, String mode) {
        return this.hosts.containsKey(vin + mode);
    }

    public Host getHost(String vin, String mode) {
        return this.hosts.get(vin + mode);
    }
}
