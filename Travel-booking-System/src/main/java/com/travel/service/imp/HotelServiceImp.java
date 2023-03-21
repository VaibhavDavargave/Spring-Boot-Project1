package com.travel.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.travel.convertor.HotelConverter;
import com.travel.entity.Hotel;
import com.travel.exception.ResourceNotFoundException;
import com.travel.model.HotelDTO;
import com.travel.repositiory.HotelRepository;
import com.travel.services.HotelService;

@Service
public class HotelServiceImp implements HotelService {
      @Autowired
	private HotelRepository hotelrepository;
	@Autowired
	private HotelConverter hotelconverter;
	
	
	
	@Override
	public String createHotel(Hotel hot) {
		String message=null;
		
		hot.setName(hot.getName());
		hot.setAddress(hot.getAddress());
		hot.setCity(hot.getCity());
		hot.setNumberOfRooms(hot.getNumberOfRooms());
		hot.setPricePerNight(hot.getPricePerNight());
		
		
		hotelrepository.save(hot);

if(hot != null)
			
		{
			message = " details added successfully!!";
		}
	
	return message;
	}

	
	
	@Override
	public HotelDTO getHotelById(int id) {
		Hotel hot = hotelrepository.findById(id).get();
		return hotelconverter.convertEntityToHotelConverter(hot);
	}

	@Override
	public List<HotelDTO> getAllHotel() {
		
		List<Hotel> hot=hotelrepository.findAll();
		List<HotelDTO> hotDTO = new ArrayList<>();
		
		for(Hotel h:hot) {
			hotDTO.add(hotelconverter.convertEntityToHotelConverter(h));
		}
		return hotDTO;
	}

	@Override
	public HotelDTO updateHotel(int id, Hotel hot) {
		Hotel ext = hotelrepository.findById(id).get();
		ext.setName(hot.getName());
		ext.setAddress(hot.getAddress());
		ext.setCity(hot.getCity());
		ext.setNumberOfRooms(hot.getNumberOfRooms());
		ext.setPricePerNight(hot.getPricePerNight());
		
		hotelrepository.save(ext);
		
		return hotelconverter.convertEntityToHotelConverter(ext);
	}



	@Override
	public String DeleteHotelById(int id) throws ResourceNotFoundException {
		String msg=null;
		Optional<Hotel> hotel=hotelrepository.findById(id);
		if(hotel.isPresent())
		{
			hotelrepository.deleteById(id);
			msg="Hotel deleted successfully!!";
		}
		else
		{
			throw new ResourceNotFoundException("Book", "Id" ,id);
		}
		return msg;
	}



	@Override
	public void deleteAllHotels() {
		hotelrepository.deleteAll();
		
	}



	@Override
	public List<HotelDTO> getHotelByName(String name) {
		List<Hotel> hotel=hotelrepository.findHotelByName(name);
		List<HotelDTO> hotelsDTO = new ArrayList<>();
		for(Hotel h : hotel)
		{
			hotelsDTO.add(hotelconverter.convertEntityToHotelConverter(h));
		}
		return hotelsDTO;
	}



	@Override
	public List<HotelDTO> getHotelByCity(String city) {
		List<Hotel> hotel=hotelrepository.findByCity(city);
		List<HotelDTO> hotelsDTO = new ArrayList<>();
		for(Hotel h : hotel )
		{
			hotelsDTO.add(hotelconverter.convertEntityToHotelConverter(h));
		}
		return hotelsDTO;
	}
	
	

}
