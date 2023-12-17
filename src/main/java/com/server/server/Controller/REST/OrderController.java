package com.server.server.Controller.REST;


import com.server.server.Controller.DTO.HotelDTO;
import com.server.server.Controller.DTO.OrderDTO;
import com.server.server.Model.Order;
import com.server.server.Service.HotelService;
import com.server.server.Service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/order"})
public class OrderController {
    private final OrderService orderService;
    private final HotelService hotelService;

    public OrderController(OrderService orderService, HotelService hotelService) {
        this.orderService = orderService;
        this.hotelService = hotelService;
    }

    //TODO
//    @PostMapping("/createOrderSneaker")
//    public OrderSneakerDTO createOrderSneaker(@RequestBody OrderSneakerDTO orderSneakerDTO){
//        return new OrderSneakerDTO(orderService.createSneakerOrder(new OrderSneaker(
//                orderService.findOrderById(orderSneakerDTO.getOrderId()),
//                hotelService.findSneaker(orderSneakerDTO.getSneakerId()),
//                orderSneakerDTO.getQuantity())));
//    }

    @PostMapping("/create")
    public Long createOrder(@RequestBody OrderDTO orderDTO){
        Order order = orderService.createOrder(orderDTO);
        return order.getId();
    }

    @GetMapping("/getUserOrders/{userId}")
    public List<OrderDTO> getUserOrders(@PathVariable("userId") Long userId){
        return orderService.getUserOrders(userId).stream().map(OrderDTO::new).toList();
    }

    @GetMapping("/getHotelFromOrder/{orderId}")
    public HotelDTO getHotelFromOrder(@PathVariable("orderId") Long orderId){
        return new HotelDTO(orderService.getHotelFromOrder(orderId));
    }

    @GetMapping("/deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId){
        orderService.deleteOrder(orderId);
    }
}