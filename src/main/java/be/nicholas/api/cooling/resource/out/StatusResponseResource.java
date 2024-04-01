package be.nicholas.api.cooling.resource.out;

import java.time.LocalDateTime;

public class StatusResponseResource {
    private DepartureTimersReportResponseResource departureTimersReport;
    private CoolingStateReportResponseResource climatisationStateReport;
    private CoolingSettingsReportResponseResource climatisationSettingsReport;
    private CoolingTemperatureReportResponseResource climatisationTemperatureReport;
    private LocalDateTime instrumentClusterTime;
    private LocalDateTime carCapturedUTCTimestamp;
    private LocalDateTime vehicleParkingClock;

    public DepartureTimersReportResponseResource getDepartureTimersReport() {
        return departureTimersReport;
    }

    public void setDepartureTimersReport(DepartureTimersReportResponseResource departureTimersReport) {
        this.departureTimersReport = departureTimersReport;
    }

    public CoolingStateReportResponseResource getClimatisationStateReport() {
        return climatisationStateReport;
    }

    public void setClimatisationStateReport(CoolingStateReportResponseResource climatisationStateReport) {
        this.climatisationStateReport = climatisationStateReport;
    }

    public CoolingSettingsReportResponseResource getClimatisationSettingsReport() {
        return climatisationSettingsReport;
    }

    public void setClimatisationSettingsReport(CoolingSettingsReportResponseResource climatisationSettingsReport) {
        this.climatisationSettingsReport = climatisationSettingsReport;
    }

    public CoolingTemperatureReportResponseResource getClimatisationTemperatureReport() {
        return climatisationTemperatureReport;
    }

    public void setClimatisationTemperatureReport(CoolingTemperatureReportResponseResource climatisationTemperatureReport) {
        this.climatisationTemperatureReport = climatisationTemperatureReport;
    }

    public LocalDateTime getInstrumentClusterTime() {
        return instrumentClusterTime;
    }

    public void setInstrumentClusterTime(LocalDateTime instrumentClusterTime) {
        this.instrumentClusterTime = instrumentClusterTime;
    }

    public LocalDateTime getCarCapturedUTCTimestamp() {
        return carCapturedUTCTimestamp;
    }

    public void setCarCapturedUTCTimestamp(LocalDateTime carCapturedUTCTimestamp) {
        this.carCapturedUTCTimestamp = carCapturedUTCTimestamp;
    }

    public LocalDateTime getVehicleParkingClock() {
        return vehicleParkingClock;
    }

    public void setVehicleParkingClock(LocalDateTime vehicleParkingClock) {
        this.vehicleParkingClock = vehicleParkingClock;
    }
}
