package com.server.server.Service;


import com.server.server.Controller.DTO.OrderDTO;
import com.server.server.Model.Hotel;
import com.server.server.Model.Order;
import com.server.server.Model.User;
import com.server.server.Repository.OrderRepository;
import com.server.server.Repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Order findOrderById(Long id){
        return orderRepository.getReferenceById(id);
    }

    @Transactional
    public Order createOrder(OrderDTO orderDTO){
        Order order = new Order(orderDTO.getDateFrom(), orderDTO.getDateTo(), orderDTO.getRooms(), orderDTO.getTotal(), userRepository.getReferenceById(orderDTO.getUserId()));
        return orderRepository.save(order);
    }


    @Transactional
    public List<Order> getUserOrders(Long userId){
        User user = userRepository.getReferenceById(userId);
        return user.getOrders();
    }

    @Transactional
    public Hotel getHotelFromOrder(Long orderId){
        Order order = orderRepository.getReferenceById(orderId);
        return order.getHotel();
    }

    @Transactional
    public void deleteOrder(Long orderId){
        orderRepository.delete(findOrderById(orderId));
    }
}
