package com.endava.ProiectEndava.DTOs;
import com.endava.ProiectEndava.models.Events;
import com.endava.ProiectEndava.models.TicketsCategory;

import java.time.LocalDateTime;
public class OrdersDTO {
    //private Integer userId;
    private Integer ordersId;
    private LocalDateTime timeStamp;
    private Integer numberOfTickets;
    private double totalPrice;
    private Integer ticketCategoryId;
    private Events event;
    private TicketsCategory ticketsCategory;

    public TicketsCategory getTicketsCategory() {
        return ticketsCategory;
    }

    public void setTicketsCategory(TicketsCategory ticketsCategory) {
        this.ticketsCategory = ticketsCategory;
    }

    public Events getEvent() {
        return event;
    }

    public void setEvent(Events event) {
        this.event = event;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }
    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Integer getTicketCategoryId() {
        return ticketCategoryId;
    }
    public Integer getOrdersId() {
        return ordersId;
    }
    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }
    public void setTicketCategoryId(Integer ticketCategoryId) {
        this.ticketCategoryId = ticketCategoryId;
    }

    public OrdersDTO(Integer ordersId, LocalDateTime timeStamp, Integer numberOfTickets, double totalPrice, Integer ticketCategoryId, Events event, TicketsCategory ticketsCategory) {
        this.ordersId = ordersId;
        this.timeStamp = timeStamp;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
        this.ticketCategoryId = ticketCategoryId;
        this.event = event;
        this.ticketsCategory = ticketsCategory;
    }

    public OrdersDTO() {}
}
