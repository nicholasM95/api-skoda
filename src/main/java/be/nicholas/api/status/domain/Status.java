package be.nicholas.api.status.domain;

import java.util.List;

public record Status(String vin, List<Data> data) {
}
