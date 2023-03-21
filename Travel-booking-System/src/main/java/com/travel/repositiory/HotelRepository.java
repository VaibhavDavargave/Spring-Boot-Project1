package com.travel.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	List<Hotel> findByCity(String city);

	

	List<Hotel> findHotelByName(String name);

	
	
}
