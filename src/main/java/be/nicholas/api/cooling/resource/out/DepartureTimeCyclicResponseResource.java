package be.nicholas.api.cooling.resource.out;

public class DepartureTimeCyclicResponseResource {
    private int weekdayBitmask;
    private int hour;
    private int minute;

    public int getWeekdayBitmask() {
        return weekdayBitmask;
    }

    public void setWeekdayBitmask(int weekdayBitmask) {
        this.weekdayBitmask = weekdayBitmask;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
