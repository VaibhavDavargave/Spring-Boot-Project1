package com.travel.service.imp;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travel.convertor.ReservationConverter;
import com.travel.entity.CarRental;
import com.travel.entity.Hotel;
import com.travel.entity.Reservation;
import com.travel.entity.User;
import com.travel.exception.ResourceNotFoundException;
import com.travel.model.ReservationDTO;
import com.travel.repositiory.CarRentalRepository;
import com.travel.repositiory.HotelRepository;
import com.travel.repositiory.ReservationRepository;
import com.travel.repositiory.UserRepository;
import com.travel.services.ReservationService;
@Service
public class ReservationServiceImp implements ReservationService {

	@Autowired
	 private ReservationRepository reservationRepository;
	@Autowired
	private CarRentalRepository carrental;
	
	@Autowired
	private UserRepository user;
	
	@Autowired
	private HotelRepository hotel;
	
	@Autowired
	private ReservationConverter reservationconverter;

	@Override
	public String createReservation(Reservation res,int carid,int hotelid,int userid) {
		String message=null;
		
		CarRental car = carrental.findById(carid).get();
		 User usr =user.findById(userid).get();
		  Hotel hot  =hotel.findById(hotelid).get();  
		  res.setCarRental(car);
		  res.setHotel(hot);
		  res.setUser(usr);
		  
		  
		reservationRepository.save(res);
		
		if(res != null)
			
		{
			message = " details added successfully!!";
		}
	
	return message;
		
	
	}
	
	

	@Override
	public ReservationDTO getReservationById(int id) {
		Reservation res =reservationRepository.findById(id).get();
		return reservationconverter.convertEntityToReservationConverter(res);
	}

	
	
	@Override
	public List<ReservationDTO> getAllReservation() {
		List<Reservation> res=reservationRepository.findAll();
		List<ReservationDTO> resDTO = new ArrayList<>();
		
		for(Reservation r:res) {
			resDTO.add(reservationconverter.convertEntityToReservationConverter(r));
		}
		
		
		return resDTO;
	}


	@Override
	public ReservationDTO updateReservation(int id, Reservation res) {
		Reservation ext = reservationRepository.findById(id).get();
		ext.setStartDate(res.getStartDate());
		ext.setEndDate(res.getEndDate());
		ext.setHotel(res.getHotel());
		ext.setUser(res.getUser());
		ext.setHotel(res.getHotel());
		ext.setCarRental(res.getCarRental());
		
		reservationRepository.save(ext);
		
		
		return reservationconverter.convertEntityToReservationConverter(ext);
	}



	@Override
	public String deleteReservationById(int id) {
		String msg=null;
		Optional<Reservation> reservation=reservationRepository.findById(id);
		if(reservation.isPresent())
		{
			reservationRepository.deleteById(id);
			msg= "Reservation deleted successfully!";
		}
		else
		{
			throw new ResourceNotFoundException("Reservation" , "Id", id);
		}
		return msg;
	}



	@Override
	public void deleteAllReservations() {
		reservationRepository.deleteAll();
		
	}



	@Override
	public List<ReservationDTO> getReservationByUserId(int Userid) {
		List<Reservation> reservation=reservationRepository.findByUser(Userid);
		List<ReservationDTO> reservationsDTO = new ArrayList<>();
		for(Reservation r : reservation )
		{
			reservationsDTO.add(reservationconverter.convertEntityToReservationConverter(r));
		}
		return reservationsDTO;
	}



	@Override
	public List<ReservationDTO> getReservationByHotelId(int HotelId) {
		List<Reservation> reservation1=reservationRepository.findByHotel(HotelId);
		List<ReservationDTO> reservationsDTO = new ArrayList<>();
		for(Reservation r : reservation1 )
		{
			reservationsDTO.add(reservationconverter.convertEntityToReservationConverter(r));
		}
		return reservationsDTO;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
