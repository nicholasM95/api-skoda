package be.nicholas.api.cooling.resource.out;

public class CoolingSettingsReportResponseResource {
    private int climatisationDuration;
    private String startMode;
    private String heaterMode;

    public int getClimatisationDuration() {
        return climatisationDuration;
    }

    public void setClimatisationDuration(int climatisationDuration) {
        this.climatisationDuration = climatisationDuration;
    }

    public String getStartMode() {
        return startMode;
    }

    public void setStartMode(String startMode) {
        this.startMode = startMode;
    }

    public String getHeaterMode() {
        return heaterMode;
    }

    public void setHeaterMode(String heaterMode) {
        this.heaterMode = heaterMode;
    }
}
