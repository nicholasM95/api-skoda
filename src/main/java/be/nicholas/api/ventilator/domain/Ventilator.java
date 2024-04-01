package be.nicholas.api.ventilator.domain;

public record Ventilator(String vin, String pin, int duration, String requestId) {
}
