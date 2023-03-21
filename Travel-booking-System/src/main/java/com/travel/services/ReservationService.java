package com.travel.services;

import java.util.List;
import com.travel.entity.Reservation;
import com.travel.model.ReservationDTO;


public interface ReservationService {

	String createReservation(Reservation res,int carid,int hotelid,int userid);
	
	ReservationDTO  getReservationById(int id);
	
	List<ReservationDTO> getAllReservation();
	
	ReservationDTO updateReservation(int id, Reservation res);
	
	String deleteReservationById(int id);
	
	void deleteAllReservations();
	
	List<ReservationDTO> getReservationByUserId(int userId);
	
	List<ReservationDTO> getReservationByHotelId(int HotelId);
	
	
	
}
