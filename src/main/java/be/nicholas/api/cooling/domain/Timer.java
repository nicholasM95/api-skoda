package be.nicholas.api.cooling.domain;

public record Timer(int id, boolean timerProgrammedStatus, int weekday,
                    int hour, int minute) {
}
