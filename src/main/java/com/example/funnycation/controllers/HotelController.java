package com.example.funnycation.controllers;

import com.example.funnycation.dto.HotelDTO;
import com.example.funnycation.dto.ApiResponse;
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
    public ResponseEntity<ApiResponse<List<Hotel>>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(new ApiResponse<>(hotels, 200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getHotelById(@PathVariable Long id) {
        Hotel hotel = hotelService.getHotelById(id);
        if (hotel != null) {
            return ResponseEntity.ok(new ApiResponse<>(hotel, 200));
        } else {
            return ResponseEntity.status(404).body(new ApiResponse<>("Hotel not found", 404));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Hotel>> createHotel(@RequestBody HotelDTO hotelDTO) {
        Hotel hotel = hotelService.createHotel(hotelDTO);
        return ResponseEntity.status(201).body(new ApiResponse<>(hotel, 201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateHotel(@PathVariable Long id, @RequestBody HotelDTO hotelDTO) {
        Hotel updatedHotel = hotelService.updateHotel(id, hotelDTO);
        if (updatedHotel != null) {
            return ResponseEntity.ok(new ApiResponse<>(updatedHotel, 200));
        } else {
            return ResponseEntity.status(404).body(new ApiResponse<>("Hotel not found", 404));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteHotel(@PathVariable Long id) {
        boolean isDeleted = hotelService.deleteHotel(id);
        if (isDeleted) {
            return ResponseEntity.status(204).body(new ApiResponse<>(null, 204));
        } else {
            return ResponseEntity.status(404).body(new ApiResponse<>("Hotel not found", 404));
        }
    }
}
