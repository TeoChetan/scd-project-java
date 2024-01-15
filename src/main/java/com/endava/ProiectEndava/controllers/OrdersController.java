package com.endava.ProiectEndava.controllers;

import com.endava.ProiectEndava.DTOs.OrderRequestDTO;
import com.endava.ProiectEndava.DTOs.OrdersDTO;
import com.endava.ProiectEndava.repositories.UsersRepository;
import com.endava.ProiectEndava.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {
    final Integer userId = 3;

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private OrdersService ordersService;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("orders")
    public List<OrdersDTO> getOrders(){
        return ordersService.getOrders(userId);
    }

    //
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/orders")
    public ResponseEntity<OrdersDTO> createOrder(@RequestBody OrderRequestDTO orderRequest) {
        OrdersDTO orderDTO = ordersService.createOrder(userId,orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO);
    }
}
