package be.nicholas.api.cooling.resource.out;

import java.time.LocalDateTime;

public class CoolingTemperatureReportResponseResource {
    private String outdoorTempValid;
    private int outdoorTemp;
    private LocalDateTime temperatureTime;

    public String getOutdoorTempValid() {
        return outdoorTempValid;
    }

    public void setOutdoorTempValid(String outdoorTempValid) {
        this.outdoorTempValid = outdoorTempValid;
    }

    public int getOutdoorTemp() {
        return outdoorTemp;
    }

    public void setOutdoorTemp(int outdoorTemp) {
        this.outdoorTemp = outdoorTemp;
    }

    public LocalDateTime getTemperatureTime() {
        return temperatureTime;
    }

    public void setTemperatureTime(LocalDateTime temperatureTime) {
        this.temperatureTime = temperatureTime;
    }
}
