package com.example.funnycation.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
