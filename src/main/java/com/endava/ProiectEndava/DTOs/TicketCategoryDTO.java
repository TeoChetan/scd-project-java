package com.endava.ProiectEndava.DTOs;

public class TicketCategoryDTO {
    private Integer ticketCategoryId;
    private String description;
    private double price;
    private Integer eventID;

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getId() {
        return ticketCategoryId;
    }
    public void setId(Integer id) {
        this.ticketCategoryId = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
