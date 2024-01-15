package com.endava.ProiectEndava.DTOs;
import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderRequestDTO implements Serializable {
    private Integer userId;
    private Integer eventId;
    private Integer ticketCategoryId;
    private Integer numberOfTickets;
    private LocalDateTime timeStamp;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    private String eventName;

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(Integer eventId, Integer ticketCategoryId, Integer numberOfTickets, LocalDateTime timeStamp) {
        this.eventId = eventId;
        this.ticketCategoryId = ticketCategoryId;
        this.numberOfTickets = numberOfTickets;
        this.timeStamp = timeStamp;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getTicketCategoryId() {
        return ticketCategoryId;
    }

    public void setTicketCategoryId(Integer ticketCategoryId) {
        this.ticketCategoryId = ticketCategoryId;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}