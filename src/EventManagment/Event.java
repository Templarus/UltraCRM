package EventManagment;

import java.sql.Date;
import java.util.logging.Logger;

public abstract class Event {
    private final int eventId;
    private Date eventDt; // дата и время события
    private SEventSeveriry eventSeverity; // важность события
    private String eventText; // собственно текст который отображается пользователю
    private SEventType eventType; // тип - устройство\служба\косяк в транспорте 1С и тд.
    private SIncEvent incId; // если >=0 - это устройство и тут лежит deviceID, если меньше = это другой источник(и может быть простая заглушка в виде -1)
    private boolean eventStatus; // заранее для Acknowledge.
    
    public Event() {
        this.eventId = -1;
    }

    public Event(int eventId, Date eventDt, SEventSeveriry eventSeverity, String eventText, SEventType eventType, SIncEvent incId, boolean eventStatus) {
        this.eventId = eventId;
        this.eventDt = eventDt;
        this.eventSeverity = eventSeverity;
        this.eventText = eventText;
        this.eventType = eventType;
        this.incId = incId;
        this.eventStatus = eventStatus;
    }

    public int getEventId() {
        return eventId;
    }

    public SEventSeveriry getEventSeverity() {
        return eventSeverity;
    }

    public String getEventText() {
        return eventText;
    }

    public SEventType getEventType() {
        return eventType;
    }

    public boolean isEventStatus() {
        return eventStatus;
    }

    public Date getEventDt() {
        return eventDt;
    }

    public void setEventDt(Date eventDt) {
        this.eventDt = eventDt;
    }

    public SIncEvent getIncId() {
        return incId;
    }

    public void setIncId(SIncEvent incId) {
        this.incId = incId;
    }

    public void setEventSeverity(SEventSeveriry eventSeverity) {
        this.eventSeverity = eventSeverity;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    public void setEventType(SEventType eventType) {
        this.eventType = eventType;
    }

    public void setEventStatus(boolean eventStatus) {
        this.eventStatus = eventStatus;
    }

    
    
}
