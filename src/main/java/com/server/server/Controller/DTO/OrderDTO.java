package com.server.server.Controller.DTO;

import com.server.server.Model.Order;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Schema(description = "Информация о заказе")
@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String dateFrom;
    private String dateTo;
    private Integer rooms;
    private Double total;
    private Long userId;
    private Long hotelId;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.dateFrom = order.getDateFrom();
        this.dateTo = order.getDateTo();
        this.rooms = order.getRooms();
        this.total = order.getTotal();
        this.userId = order.getUser().getId();
        this.hotelId = order.getHotel().getId();
    }
}
