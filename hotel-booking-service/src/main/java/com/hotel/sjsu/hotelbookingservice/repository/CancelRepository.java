package com.hotel.sjsu.hotelbookingservice.repository;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CancelRepository extends CrudRepository<BookingEntity, Long> {


    @Query("SELECT b from booking b where b.bookingId=?1 and b.bookingStatus='Booked'" )
     BookingEntity getbookingBybookingId(Long booking_id);

    @Modifying
    @Query("UPDATE booking b set b.bookingStatus='Cancelled' where b.bookingId=?1" )
     void cancelBookingStatus(Long booking_id);

    @Query("select c.loyaltyPoints from customer c where c.customerId=?1" )
    Integer getLoyaltyPoints(Long customer_id );

    @Modifying
    @Query("UPDATE customer c set c.loyaltyPoints=?1 where c.customerId=?2" )
    void updateLoyaltyPoints(Integer loyalty_points, Long customer_id );


    //refund paid amt
    @Modifying
    @Query("UPDATE booking b set b.totalAmount=?1 where b.bookingId=?2" )
    void updateTotalAmount(Double total_amount, Long booking_id );





}
