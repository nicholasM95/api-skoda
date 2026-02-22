package be.nicholas.api.vehicle.domain;

public record Vehicle(String vin, String name, String licensePlate, String state, String devicePlatform,
                      String systemModelId, String title) {
}
