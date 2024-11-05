package com.example.funnycation.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String description;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
}
