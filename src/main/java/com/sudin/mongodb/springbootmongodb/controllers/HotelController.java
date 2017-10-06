package com.sudin.mongodb.springbootmongodb.controllers;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.sudin.mongodb.springbootmongodb.model.Hotel;
import com.sudin.mongodb.springbootmongodb.model.QHotel;
import com.sudin.mongodb.springbootmongodb.repositories.HotelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @RequestMapping("/all")
    public List<Hotel> getAll() {
        List<Hotel> hotels = this.hotelRepository.findAll();
        return hotels;
    }

    @PutMapping
    public void insert(@RequestBody Hotel hotel) {
        this.hotelRepository.insert(hotel);
    }

    @PostMapping
    public void update(@RequestBody Hotel hotel) {
        this.hotelRepository.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.hotelRepository.delete(id);
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") String id) {
        Hotel hotel = this.hotelRepository.findById(id);
        return hotel;
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice) {
        List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
        return hotels;
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city) {
        List<Hotel> hotels = this.hotelRepository.findByCity(city);
        return hotels;
    }

    @GetMapping("/country/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country) {
        //create a query class (QHotel)
        QHotel qHotel = new QHotel("hotel");

        //Using the query class we can create filters
        BooleanExpression filterByCountry = qHotel.address.country.eq(country);

        //We can then pass the filters to the findAll() method
        List<Hotel> hotels = (List<Hotel>) this.hotelRepository.findAll(filterByCountry);
        return hotels;

    }

}
