package com.sudin.mongodb.springbootmongodb.repositories;

import com.sudin.mongodb.springbootmongodb.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String> {

    Hotel findById(String id);

    List<Hotel> findByPricePerNightLessThan(int maxPrice);
}
