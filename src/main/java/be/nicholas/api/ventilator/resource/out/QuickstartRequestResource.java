package be.nicholas.api.ventilator.resource.out;

public class QuickstartRequestResource {

    private int climatisationDuration;
    //private String startMode;
    private boolean active;

    public int getClimatisationDuration() {
        return climatisationDuration;
    }

    public void setClimatisationDuration(int climatisationDuration) {
        this.climatisationDuration = climatisationDuration;
    }

    /*public String getStartMode() {
        return startMode;
    }

    public void setStartMode(String startMode) {
        this.startMode = startMode;
    }*/

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
