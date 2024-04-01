package be.nicholas.api.ventilator.resource.out;

public class PerformActionRequestResource {
    private QuickstopRequestResource quickstop;
    private QuickstartRequestResource quickstart;

    public QuickstopRequestResource getQuickstop() {
        return quickstop;
    }

    public void setQuickstop(QuickstopRequestResource quickstop) {
        this.quickstop = quickstop;
    }

    public QuickstartRequestResource getQuickstart() {
        return quickstart;
    }

    public void setQuickstart(QuickstartRequestResource quickstart) {
        this.quickstart = quickstart;
    }
}
