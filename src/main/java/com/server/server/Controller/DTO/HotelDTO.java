package com.server.server.Controller.DTO;


import com.server.server.Model.Hotel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Информация о кроссовке")
@Getter
@Setter
@NoArgsConstructor
public class HotelDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer img;
    private Integer stars;
    private String location;
    private String info;

    public HotelDTO(Hotel hotel) {
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.price = hotel.getPrice();
        this.img = hotel.getImg();
        this.stars = hotel.getStars();
        this.location = hotel.getLocation();
        this.info = hotel.getInfo();
    }
}