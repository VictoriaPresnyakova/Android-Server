package com.server.server.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "_order")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateFrom;
    private String dateTo;
    private Integer rooms;
    private Double total;
    @OneToOne
    private Hotel hotel;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Order(String dateFrom, String dateTo, Integer rooms, Double total, User user){
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.rooms = rooms;
        this.total = total;
        this.user = user;
    }
}
