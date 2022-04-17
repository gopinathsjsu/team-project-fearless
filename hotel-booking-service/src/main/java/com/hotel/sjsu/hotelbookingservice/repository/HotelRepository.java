package com.hotel.sjsu.hotelbookingservice.repository;
import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, String> {

    List<HotelEntity> findByhotelLocation(String hotel_location);


    @Query("SELECT h.hotelId from hotel h where h.hotelLocation=?1" )
    //public List<HotelEntity> gethotelIdByhotelLocation(String hotel_location);
    public List<Integer> gethotelIdByhotelLocation(String hotel_location);



    @Query("SELECT b from booking b where b.hotelId=?1 and b.bookingStatus='Booked' and (booking_date_from BETWEEN ?2 AND ?3 or booking_date_to BETWEEN ?2 AND ?3)" )
    //public List<HotelEntity> gethotelIdByhotelLocation(String hotel_location);
    public List<BookingEntity> getbookingIdsByhotelId(Long hotel_id, String fromDate, String toDate);


}
