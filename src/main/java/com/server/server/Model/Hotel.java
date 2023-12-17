package com.server.server.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "_hotel")
@Getter
@Setter
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer img;
    private Integer stars;
    private String location;
    private String info;




    public Hotel(String name, Double price, Integer img, Integer stars, String location, String info) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.stars = stars;
        this.location = location;
        this.info = info;
    }
}