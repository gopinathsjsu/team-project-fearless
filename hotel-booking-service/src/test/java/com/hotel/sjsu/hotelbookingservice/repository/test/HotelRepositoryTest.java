package com.hotel.sjsu.hotelbookingservice.repository.test;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HotelRepositoryTest {

    @Autowired
    private HotelRepository hotelRepository;
/*
    @Test
    @Order(1)
    @Rollback(value = false)
    public void getHotelListTest(){

        List<HotelEntity> hotelEntityList = hotelRepository.findByhotelLocation("San Francisco");
        Assertions.assertThat(hotelEntityList.size()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getBookingIdListTest(){

        List<BookingEntity> bookingEntityList = hotelRepository.getbookingIdsByhotelId(4L,"2022-07-01","2022-07-04");
        Assertions.assertThat(bookingEntityList.size()).isGreaterThan(0);


    }*/
}
