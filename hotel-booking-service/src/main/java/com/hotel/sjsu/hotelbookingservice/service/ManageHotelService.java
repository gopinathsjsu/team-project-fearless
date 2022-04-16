package com.hotel.sjsu.hotelbookingservice.service;
import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRepository;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class ManageHotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    EntityToModelMapper entityToModelMapper;

    public List<HotelEntity> getAllHotels () {

        return (List<HotelEntity>) hotelRepository.findAll();

    }

    public List<Hotel> getHotel(String hotel_location) {

        List<HotelEntity> hotelEntityList = new ArrayList<HotelEntity>();
        hotelEntityList = hotelRepository.findByhotelLocation(hotel_location);

        List<Hotel> hotelList = new ArrayList<Hotel>();

        for(HotelEntity hotelEntity : hotelEntityList){
            hotelList.add(new Hotel(hotelEntity));
        }

        return hotelList;
    }

//    public List<Hotel>  gethotelDetails(String hotel_id) {
//        return hotelRepository.gethotel(hotel_location);
//    }
//

    public List<Integer> gethotelIds(String hotel_location) {
        return hotelRepository.gethotelIdByhotelLocation(hotel_location);
    }


    public List<String> getbookingIds(Long hotel_id , String fromDate, String toDate) {
        List<BookingEntity> bookingEntList = new ArrayList<BookingEntity>();
        bookingEntList = hotelRepository.getbookingIdsByhotelId(hotel_id, fromDate, toDate);

        //System.out.println("Booking Entity=  "+bookingEntList);
        List<String> bookingList = new ArrayList<String>();

        for(BookingEntity bookingEntity : bookingEntList){
            bookingList.add(entityToModelMapper.mapBooking(bookingEntity).getRoom());
        }

//        return hotelRepository.getbookingIdsByhotelId(hotel_id);

        return bookingList;
    }
}
