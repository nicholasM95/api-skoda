package be.nicholas.api.status.resource.out;

import java.time.LocalDateTime;

public class FieldResponseResource {
    private String id;
    private LocalDateTime tsCarSentUtc;
    private LocalDateTime tsCarSent;
    private LocalDateTime tsCarCaptured;
    private LocalDateTime tsTssReceivedUtc;
    private Integer milCarCaptured;
    private Integer milCarSent;
    private String value;
    private String unit;
    private String textId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTsCarSentUtc() {
        return tsCarSentUtc;
    }

    public void setTsCarSentUtc(LocalDateTime tsCarSentUtc) {
        this.tsCarSentUtc = tsCarSentUtc;
    }

    public LocalDateTime getTsCarSent() {
        return tsCarSent;
    }

    public void setTsCarSent(LocalDateTime tsCarSent) {
        this.tsCarSent = tsCarSent;
    }

    public LocalDateTime getTsCarCaptured() {
        return tsCarCaptured;
    }

    public void setTsCarCaptured(LocalDateTime tsCarCaptured) {
        this.tsCarCaptured = tsCarCaptured;
    }

    public LocalDateTime getTsTssReceivedUtc() {
        return tsTssReceivedUtc;
    }

    public void setTsTssReceivedUtc(LocalDateTime tsTssReceivedUtc) {
        this.tsTssReceivedUtc = tsTssReceivedUtc;
    }

    public Integer getMilCarCaptured() {
        return milCarCaptured;
    }

    public void setMilCarCaptured(Integer milCarCaptured) {
        this.milCarCaptured = milCarCaptured;
    }

    public Integer getMilCarSent() {
        return milCarSent;
    }

    public void setMilCarSent(Integer milCarSent) {
        this.milCarSent = milCarSent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTextId() {
        return textId;
    }

    public void setTextId(String textId) {
        this.textId = textId;
    }
}
