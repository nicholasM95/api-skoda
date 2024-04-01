package be.nicholas.api.pin.resource.out;

public class PinRequestResource {
    private PinAuthenticationRequestResource securityPinAuthentication;

    public PinAuthenticationRequestResource getSecurityPinAuthentication() {
        return securityPinAuthentication;
    }

    public void setSecurityPinAuthentication(PinAuthenticationRequestResource securityPinAuthentication) {
        this.securityPinAuthentication = securityPinAuthentication;
    }
}
