package com.travel.repositiory;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.entity.CarRental;
import com.travel.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByUser(int userId);
	
	List<Reservation> findByHotel(int hotelId);
	
	List<Reservation> findByCarRental(CarRental carRental);
	

}
