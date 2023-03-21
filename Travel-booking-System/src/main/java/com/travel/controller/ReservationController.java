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
import com.travel.convertor.ReservationConverter;
import com.travel.entity.Reservation;

import com.travel.model.ReservationDTO;

import com.travel.services.ReservationService;

@RestController
@RequestMapping("/Reservation")
public class ReservationController {
	
	@Autowired
private ReservationService reservationservice;
	
	@Autowired
	private ReservationConverter reservationconverter;
	
	@PostMapping("/createReservation/{carid}/{hotel}/{user}")
	public String createReservation(@RequestBody ReservationDTO resDTO,@PathVariable("carid") int carid,
			@PathVariable("hotel") int hotelid, @PathVariable("user") int userid)
	{
		final Reservation res = reservationconverter.convertDTOToReservation(resDTO);
		return reservationservice.createReservation(res, carid,hotelid,userid);
		
	}
	
	@GetMapping("/getreservationById/{id}")
	public ReservationDTO getReservationById(@PathVariable("id")int id)
	{
		return reservationservice.getReservationById(id);
	}
	
	@GetMapping("/getAllReservation")
	public List<ReservationDTO> getAllReservation(){
		return reservationservice.getAllReservation();
	}
	
	@PutMapping("/updateReservation/{id}")
	public ReservationDTO updateReservation(@PathVariable("id") int id,
			@RequestBody ReservationDTO resDTO) {
		Reservation res1 = reservationconverter.convertDTOToReservation(resDTO);
		return reservationservice.updateReservation(id, res1);
	}
	
	@DeleteMapping("deleteReservationById/{id}")
	public String deleteReservationById(@PathVariable("id") int id) 
	{
			return reservationservice.deleteReservationById(id);
	}
	
	@DeleteMapping("/deleteAllReservations")
	public ResponseEntity<String> deleteAllReservations()
	{
		reservationservice.deleteAllReservations();
		return new ResponseEntity<String>("All Reservation details got deleted!",
				HttpStatus.OK);
	}
	
	@GetMapping("/getReservationByUserId/{Id}")
	public List<ReservationDTO> getReservationByUser(@PathVariable("Id")int UserId)
	{
		return reservationservice.getReservationByUserId(UserId);
	}
	
	@GetMapping("/getReservationByHotelId/{Id}")
	public List<ReservationDTO> getReservationByHotel(@PathVariable("Id") int HotelId)
	{
		return reservationservice.getReservationByHotelId(HotelId);
	}
	}

