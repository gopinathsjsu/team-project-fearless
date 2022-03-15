package com.hotel.sjsu.hotelbookingservice.repository;


//import com.hotel.sjsu.hotelbookingservice.model.Hotel;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotel.sjsu.hotelbookingservice.entity.SearchHotelEntity;

//import java.util.List;

@Repository
public interface SearchHotelRepository extends CrudRepository<SearchHotelEntity, Integer>{
//public interface SearchHotelRepository extends JpaRepository<SearchHotelEntity, Integer> {

//    Iterable<Object> findAllById(String s);

//  List<Hotel> findByHotelLocation(String hotel_location);
//public interface SearchHotelRepository extends CrudRepository<Hotel, String>{
//    @Query("Select hotelname from hotel where hotel_location ='San Jose' ")
//    List<Hotel> findByHotelLocation(String chars);

//    List<Hotel> findByLocation(String hotel_location);
//    List<hotelnames> findByHotelLocation(String hotel_location);
//    List<hotelnames> findAll();

//    public List<SearchHotelEntity> findByHotelLocation (String hotel_location);

//    @Query("select h from hotel h where h.hotel_location =:n ")
////    @Query(value = "select * from hotel where hotel_location ", nativeQuery = true)
//    public List<SearchHotelEntity> getHotelByHotelLocation(@Param("n") String hotel_location);

}

