package be.nicholas.api.core.auth.pin;

public interface PinLogin {
    String doPinLogin(final String vin, final String pin);
}
