package be.nicholas.api.pin.resource.out;

public class SecurityPinRequestResource {
    private String challenge;
    private String securityPinHash;

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public String getSecurityPinHash() {
        return securityPinHash;
    }

    public void setSecurityPinHash(String securityPinHash) {
        this.securityPinHash = securityPinHash;
    }
}
