package be.nicholas.api.pin.resource.out;

public class PinAuthenticationRequestResource {
    private SecurityPinRequestResource securityPin;
    private String securityToken;

    public SecurityPinRequestResource getSecurityPin() {
        return securityPin;
    }

    public void setSecurityPin(SecurityPinRequestResource securityPin) {
        this.securityPin = securityPin;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }
}
