package com.example.funnycation.controllers;

import com.example.funnycation.dto.ApiResponse;
import com.example.funnycation.dto.HotelDTO;
import com.example.funnycation.models.Hotel;
import com.example.funnycation.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        ApiResponse<List<Hotel>> response = new ApiResponse<>(hotels, HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    // @GetMapping
    // public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
    // List<User> users = userService.getAllUsers();
    // ApiResponse<List<User>> response = new ApiResponse<>(users,
    // HttpStatus.OK.value());
    // return ResponseEntity.ok(response);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Hotel hotel = hotelService.getHotelById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        return ResponseEntity.ok(hotel);
    }

    @PostMapping
    public Hotel createHotel(@RequestBody HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDTO.getName());
        hotel.setAddress(hotelDTO.getAddress());
        hotel.setRating(hotelDTO.getRating());
        hotel.setPhone(hotelDTO.getPhone());

        return hotelService.createHotel(hotel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDTO.getName());
        hotel.setAddress(hotelDTO.getAddress());
        hotel.setRating(hotelDTO.getRating());
        hotel.setPhone(hotelDTO.getPhone());

        Hotel updatedHotel = hotelService.updateHotel(id, hotel);
        return updatedHotel != null ? ResponseEntity.ok(updatedHotel) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }
}
