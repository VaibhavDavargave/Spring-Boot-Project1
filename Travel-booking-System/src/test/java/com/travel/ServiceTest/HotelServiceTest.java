package com.travel.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.travel.convertor.HotelConverter;
import com.travel.entity.Hotel;
import com.travel.model.HotelDTO;
import com.travel.repositiory.HotelRepository;
import com.travel.services.HotelService;

@SpringBootTest
public class HotelServiceTest {
	
	@Autowired
	private HotelService hotelservice;
	
	@Autowired
	private HotelConverter hotelconverter;
	
	@MockBean
	private HotelRepository hotelRepository;
	
	@Test
	void testCreateHotel()
	{
		Hotel hotel = Hotel.builder().name("vaibhav").address("near katraj").city("pune").numberOfRooms(2).pricePerNight(10000.80).build();
		
		Mockito.when(hotelRepository.save(hotel)).thenReturn(hotel);
		assertEquals(" details added successfully!!", hotelservice.createHotel(hotel));
		assertThat(hotelservice.createHotel(hotel)).isEqualTo(" details added successfully!!");
	}
	
	@Test
	void testGetHotelById()
	{
		 Hotel hotel1 = Hotel.builder().hotelId(3).name("vaishali").address("FC Road").city("Pune").numberOfRooms(4).pricePerNight(20000.50).build();
		 
		 Mockito.when(hotelRepository.save(hotel1)).thenReturn(hotel1);
		 assertEquals("vaishali",hotel1.getName());
	}
	
	@Test
	void testGetAllHotels()
	{
		Hotel hotel = Hotel.builder().name("vaishali").address("FC Road").city("Pune").numberOfRooms(4).pricePerNight(20000.50).build();
		Hotel hotel1 = Hotel.builder().name("Taj hotel").address("near gateway of India").city("Mumbai").numberOfRooms(2).pricePerNight(10000.50).build();
		
		List<Hotel> list = new ArrayList<>();
		list.add(hotel);
		list.add(hotel1);
		
		Mockito.when(hotelRepository.findAll()).thenReturn(list);
		
		List<HotelDTO> dto = hotelservice.getAllHotel();
		List<Hotel> hotels = new ArrayList<Hotel>();
		dto.forEach(hotelDto->
		hotels.add(hotelconverter.convertDTOToHotel(hotelDto)));
		
		assertThat(hotels.get(0).getName()).isEqualTo(list.get(0).getName());
		
		
	}
	
	@Test
	void testUpdateHotel()
	{
		Hotel hotel = Hotel.builder().name("vaishali").address("FC Road").city("Pune").numberOfRooms(4).pricePerNight(20000.50).build();
		
		Optional<Hotel> opHotel = Optional.of(hotel);
		
		Mockito.when(hotelRepository.findById(hotel.getHotelId())).thenReturn(opHotel);
		
		Hotel  h = opHotel.get();
		hotel.setName("Indrayani");
		
		Mockito.when(hotelRepository.save(hotel)).thenReturn(h);
		
		HotelDTO dto = hotelservice.updateHotel(hotel.getHotelId(), hotel);
		assertEquals(dto.getName(), h.getName());
		
		
		
	}
	

}
