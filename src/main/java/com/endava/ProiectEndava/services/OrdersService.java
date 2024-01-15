package com.endava.ProiectEndava.services;
import com.endava.ProiectEndava.DTOs.EventsDTO;
import com.endava.ProiectEndava.DTOs.OrderRequestDTO;
import com.endava.ProiectEndava.DTOs.OrdersDTO;
import com.endava.ProiectEndava.DTOs.TicketCategoryDTO;
import com.endava.ProiectEndava.models.Events;
import com.endava.ProiectEndava.models.Orders;
import com.endava.ProiectEndava.models.TicketsCategory;
import com.endava.ProiectEndava.repositories.EventsRepository;
import com.endava.ProiectEndava.repositories.OrdersRepository;
import com.endava.ProiectEndava.repositories.TicketsCategoryRepository;
import com.endava.ProiectEndava.repositories.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrdersService implements IOrdersService{
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private TicketsCategoryRepository ticketsCategoryRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private EventsRepository eventsRepository;

    public OrdersService(OrdersRepository ordersRepository, TicketsCategoryRepository ticketsCategoryRepository,EventsRepository eventsRepository) {
        this.ordersRepository = ordersRepository;
        this.ticketsCategoryRepository = ticketsCategoryRepository;
        this.eventsRepository = eventsRepository;
    }
    @Override
    public List<OrdersDTO> getOrders(Integer userId) {

        List<Orders> ordersList =  ordersRepository.findOrdersByUserUserId(userId);
        List<OrdersDTO> ordersDTOList = new ArrayList<>();
        for (Orders orders : ordersList){
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.setOrdersId(orders.getOrdersId());
            ordersDTO.setTimeStamp(orders.getOrderedAt());
            ordersDTO.setTicketCategoryId(orders.getTicketCategory().getTicketCategoryId());
            ordersDTO.setNumberOfTickets(orders.getNumberOfTickets());
            ordersDTO.setTotalPrice(orders.getTotalPrice());
            //
            ordersDTO.setEvent(orders.getTicketCategory().getEvent());
            ordersDTO.setTicketsCategory(orders.getTicketCategory());
            ordersDTOList.add(ordersDTO);
        }
        return ordersDTOList;
    }
    public OrdersDTO createOrder(Integer userId,OrderRequestDTO orderRequestDTO){
        //List<Orders> newOrdersList =  ordersRepository.findOrdersByUserUserId(userId);
        Integer eventId = orderRequestDTO.getEventId();
        Integer ticketCategoryId = orderRequestDTO.getTicketCategoryId();
        Integer numberOfTickets = orderRequestDTO.getNumberOfTickets();
        LocalDateTime timeStamp = LocalDateTime.now();
        TicketsCategory ticketsCategory = ticketsCategoryRepository.findById(ticketCategoryId).orElseThrow(()->new EntityNotFoundException("TicketNotFound"));
        double totalPrice = ticketsCategory.getPrice() * numberOfTickets;
        //
        Events eventName = ticketsCategory.getEvent();


        Orders newOrder = new Orders();
        OrdersDTO ordersDTO = new OrdersDTO();
        newOrder.setOrderedAt(timeStamp);
        newOrder.setTicketCategory(ticketsCategory);
        newOrder.setNumberOfTickets(numberOfTickets);
        newOrder.setTotalPrice(totalPrice);
        newOrder.setUser(usersRepository.findById(userId).orElse(null));


        newOrder = ordersRepository.save(newOrder);
        ordersDTO.setOrdersId(eventId);
        ordersDTO.setTimeStamp(newOrder.getOrderedAt());
        ordersDTO.setTicketCategoryId(newOrder.getTicketCategory().getTicketCategoryId());
        ordersDTO.setNumberOfTickets(newOrder.getNumberOfTickets());
        ordersDTO.setTotalPrice(newOrder.getTotalPrice());
        ordersDTO.setEvent(eventName);
        ordersDTO.setTicketsCategory(ticketsCategory);

        //ordersDTO = ordersRepository.save(ordersDTO);
        return ordersDTO;



    }


}
