package com.example.funnycation.controllers;

import com.example.funnycation.dto.HotelDTO;
import com.example.funnycation.models.Hotel;
import com.example.funnycation.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Hotel hotel = hotelService.getHotelById(id);
        return hotel != null ? ResponseEntity.ok(hotel) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Hotel createHotel(@RequestBody HotelDTO hotelDTO) {
        return hotelService.createHotel(hotelDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody HotelDTO hotelDTO) {
        Hotel updatedHotel = hotelService.updateHotel(id, hotelDTO);
        return updatedHotel != null ? ResponseEntity.ok(updatedHotel) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }
}
