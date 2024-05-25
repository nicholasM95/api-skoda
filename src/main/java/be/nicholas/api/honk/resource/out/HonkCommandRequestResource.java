package be.nicholas.api.honk.resource.out;

public class HonkCommandRequestResource {
    private PositionRequestResource userPosition;
    private int serviceDuration;
    private String serviceOperationCode;

    public PositionRequestResource getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(PositionRequestResource userPosition) {
        this.userPosition = userPosition;
    }

    public int getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(int serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public String getServiceOperationCode() {
        return serviceOperationCode;
    }

    public void setServiceOperationCode(String serviceOperationCode) {
        this.serviceOperationCode = serviceOperationCode;
    }
}
