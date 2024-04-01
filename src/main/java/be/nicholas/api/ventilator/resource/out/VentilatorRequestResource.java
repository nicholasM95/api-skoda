package be.nicholas.api.ventilator.resource.out;

public class VentilatorRequestResource {
    private PerformActionRequestResource performAction;

    public PerformActionRequestResource getPerformAction() {
        return performAction;
    }

    public void setPerformAction(PerformActionRequestResource performAction) {
        this.performAction = performAction;
    }
}
