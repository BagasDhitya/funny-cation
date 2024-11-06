package com.example.funnycation.services;

import com.example.funnycation.repositories.HotelRepository;
import com.example.funnycation.models.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    // Get all hotels
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Get hotel by id
    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    // Create new hotel
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // Update existing hotel
    public Hotel updateHotel(Long id, Hotel hotelDetails) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));
        hotel.setName(hotelDetails.getName());
        hotel.setAddress(hotelDetails.getAddress());
        hotel.setRating(hotelDetails.getRating());
        hotel.setPhone(hotelDetails.getPhone());
        return hotelRepository.save(hotel);
    }

    // Delete hotel by id
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
