package com.example.funnycation.services;

import com.example.funnycation.dto.HotelDTO;
import com.example.funnycation.models.Hotel;
import com.example.funnycation.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public Hotel createHotel(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDTO.getName());
        hotel.setLocation(hotelDTO.getLocation());
        hotel.setDescription(hotelDTO.getDescription());
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long id, HotelDTO hotelDTO) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            hotel.setName(hotelDTO.getName());
            hotel.setLocation(hotelDTO.getLocation());
            hotel.setDescription(hotelDTO.getDescription());
            return hotelRepository.save(hotel);
        }
        return null;
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
