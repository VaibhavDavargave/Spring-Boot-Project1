package com.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.convertor.HotelConverter;
import com.travel.entity.Hotel;
import com.travel.model.HotelDTO;
import com.travel.services.HotelService;

@RestController
@RequestMapping("/Hotel")
public class HotelController {
    @Autowired
	private HotelService hotelservice;
	@Autowired
	private HotelConverter hotelconverter;
	
	@PostMapping("/createhotel")
	public String createHotel(@RequestBody HotelDTO hotDTO)
	{
		final Hotel hot = hotelconverter.convertDTOToHotel(hotDTO);
		return hotelservice.createHotel(hot);
		
	}
	
	@GetMapping("/gethotelById/{id}")
	public HotelDTO getHotelById(@PathVariable("id")int id)
	{
		return hotelservice.getHotelById(id);
	}
	
	@GetMapping("/getAllhotel")
	public List<HotelDTO> getAllHotel(){
		return hotelservice.getAllHotel();
	}
	
	@PutMapping("/updatehotel/{id}")
	public HotelDTO updateHotel(@PathVariable("id") int id,
			@RequestBody HotelDTO hotDTO) {
		Hotel hot1 =hotelconverter .convertDTOToHotel(hotDTO);
		return hotelservice.updateHotel(id , hot1);
	}
	
	@DeleteMapping("/deleteHotelById/{id}")
	public String deleteHotelById(@PathVariable("id") int id)
	{
		return hotelservice.DeleteHotelById(id);
	}
	
	@DeleteMapping("/DeleteAllHotels")
	public ResponseEntity<String> deleteAllHotels()
	{
		hotelservice.deleteAllHotels();
		return new ResponseEntity<String>("All hotel details got deleted!",
				HttpStatus.OK);
	}
	
	@GetMapping("/GetHotelByName/{name}")
	public List<HotelDTO> getHotelByName(@PathVariable("name") String name)
	{
		return hotelservice.getHotelByName(name);
	}
	
	@GetMapping("/GetHotelByCity/{city}")
	public List<HotelDTO> getHotelByCity(@PathVariable("city") String city)
	{
		return hotelservice.getHotelByCity(city);
	}
	
	
	
	
	
	
}
