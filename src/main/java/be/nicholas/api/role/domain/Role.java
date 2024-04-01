package be.nicholas.api.role.domain;

import java.util.List;
import java.util.Map;

public record Role(List<Map<String, Object>> services) {
}
