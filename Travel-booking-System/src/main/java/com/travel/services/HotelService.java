package com.travel.services;

import java.util.List;

import com.travel.entity.Hotel;
import com.travel.model.HotelDTO;

public interface HotelService {

	
String createHotel(Hotel hot);
	
	HotelDTO getHotelById(int id);
	
	List<HotelDTO> getAllHotel();
	
	HotelDTO updateHotel(int id, Hotel hot);
	
	String DeleteHotelById(int id);
	
	void deleteAllHotels();
	
	List<HotelDTO> getHotelByName(String name);
	
	List<HotelDTO> getHotelByCity(String city);
}
