package com.travel.convertor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.travel.entity.Reservation;
import com.travel.model.ReservationDTO;



@Component
public class ReservationConverter {
	//converts from reservation entity to reservationDTO
	public ReservationDTO convertEntityToReservationConverter(Reservation res) {
		ReservationDTO resDTO = new ReservationDTO();
		if(res!=null)
		{
			BeanUtils.copyProperties(res, resDTO);
		}
		return resDTO;
	}
	//converts from reservationDTO to reservation entity
	public Reservation  convertDTOToReservation(ReservationDTO resDTO)
	{
		Reservation res = new Reservation();
		if(resDTO!= null) {
			BeanUtils.copyProperties(resDTO, res);
			
		}
		return res;
	}
	
	
	
}
