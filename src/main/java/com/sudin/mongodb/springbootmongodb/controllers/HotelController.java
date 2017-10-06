package com.sudin.mongodb.springbootmongodb.controllers;

import com.sudin.mongodb.springbootmongodb.model.Hotel;
import com.sudin.mongodb.springbootmongodb.repositories.HotelRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @RequestMapping("/all")
    public List<Hotel> getAll(){
        List<Hotel> hotels=this.hotelRepository.findAll();
        return hotels;
    }

}
