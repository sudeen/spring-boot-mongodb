package com.sudin.mongodb.springbootmongodb;

import com.sudin.mongodb.springbootmongodb.model.Address;
import com.sudin.mongodb.springbootmongodb.model.Hotel;
import com.sudin.mongodb.springbootmongodb.model.Review;
import com.sudin.mongodb.springbootmongodb.repositories.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@SpringBootApplication
public class SpringBootMongodbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbApplication.class, args);
    }

    private HotelRepository hotelRepository;

    public SpringBootMongodbApplication(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris","France"),
                Arrays.asList(
                        new Review("sudin",8,false),
                        new Review("ranjitkar",9,true)
                )
        );

        Hotel ibis = new Hotel(
                "Ibis",
                150,
                new Address("Kathmandu","Nepal"),
                Arrays.asList(
                        new Review("sudeen",9,false),
                        new Review("ranjit",9,true)
                )
        );
        Hotel waka = new Hotel(
                "Waka",
                200,
                new Address("Sydney","Australia"),
             new ArrayList<>()
        );

        //drop all hotels
        this.hotelRepository.deleteAll();

        //add hotels to database
        List<Hotel> hotels=Arrays.asList(marriot,ibis,waka);
        this.hotelRepository.save(hotels);
    }
}
