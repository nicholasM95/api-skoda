package be.nicholas.api.pin.resource.out;

public class PinTransmissionResponseResource {
    private String hashProcedureVersion;
    private String challenge;

    public String getHashProcedureVersion() {
        return hashProcedureVersion;
    }

    public void setHashProcedureVersion(String hashProcedureVersion) {
        this.hashProcedureVersion = hashProcedureVersion;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }
}
