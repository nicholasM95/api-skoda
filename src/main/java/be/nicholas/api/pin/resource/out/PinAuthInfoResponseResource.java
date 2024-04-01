package be.nicholas.api.pin.resource.out;

public class PinAuthInfoResponseResource {
    private String securityToken;
    private PinTransmissionResponseResource securityPinTransmission;
    private String remainingTries;

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public PinTransmissionResponseResource getSecurityPinTransmission() {
        return securityPinTransmission;
    }

    public void setSecurityPinTransmission(PinTransmissionResponseResource securityPinTransmission) {
        this.securityPinTransmission = securityPinTransmission;
    }

    public String getRemainingTries() {
        return remainingTries;
    }

    public void setRemainingTries(String remainingTries) {
        this.remainingTries = remainingTries;
    }
}
