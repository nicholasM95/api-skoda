package be.nicholas.api.pin.resource.out;

public class PinResponseResource {
    private PinAuthInfoResponseResource securityPinAuthInfo;

    public PinAuthInfoResponseResource getSecurityPinAuthInfo() {
        return securityPinAuthInfo;
    }

    public void setSecurityPinAuthInfo(PinAuthInfoResponseResource securityPinAuthInfo) {
        this.securityPinAuthInfo = securityPinAuthInfo;
    }
}
