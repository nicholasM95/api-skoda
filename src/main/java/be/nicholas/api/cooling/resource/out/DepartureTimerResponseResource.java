package be.nicholas.api.cooling.resource.out;

public class DepartureTimerResponseResource {
    private int timerID;
    private boolean timerProgrammedStatus;
    private DepartureTimeCyclicResponseResource departureTimeCyclic;

    public int getTimerID() {
        return timerID;
    }

    public void setTimerID(int timerID) {
        this.timerID = timerID;
    }

    public boolean isTimerProgrammedStatus() {
        return timerProgrammedStatus;
    }

    public void setTimerProgrammedStatus(boolean timerProgrammedStatus) {
        this.timerProgrammedStatus = timerProgrammedStatus;
    }

    public DepartureTimeCyclicResponseResource getDepartureTimeCyclic() {
        return departureTimeCyclic;
    }

    public void setDepartureTimeCyclic(DepartureTimeCyclicResponseResource departureTimeCyclic) {
        this.departureTimeCyclic = departureTimeCyclic;
    }
}
