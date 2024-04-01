package be.nicholas.api.cooling.resource.out;

public class CoolingStateReportResponseResource {
    private String climatisationState;
    private int climatisationDuration;
    private int remainingClimateTime;
    private int climateStatusCode;

    public String getClimatisationState() {
        return climatisationState;
    }

    public void setClimatisationState(String climatisationState) {
        this.climatisationState = climatisationState;
    }

    public int getClimatisationDuration() {
        return climatisationDuration;
    }

    public void setClimatisationDuration(int climatisationDuration) {
        this.climatisationDuration = climatisationDuration;
    }

    public int getRemainingClimateTime() {
        return remainingClimateTime;
    }

    public void setRemainingClimateTime(int remainingClimateTime) {
        this.remainingClimateTime = remainingClimateTime;
    }

    public int getClimateStatusCode() {
        return climateStatusCode;
    }

    public void setClimateStatusCode(int climateStatusCode) {
        this.climateStatusCode = climateStatusCode;
    }
}
