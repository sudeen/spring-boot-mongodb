package com.sudin.mongodb.springbootmongodb.repositories;

import com.sudin.mongodb.springbootmongodb.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String> {
}
