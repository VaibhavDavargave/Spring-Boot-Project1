package com.travel.model;

import java.time.LocalDate;


import com.travel.entity.CarRental;

import com.travel.entity.Hotel;
import com.travel.entity.User;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {
	 private int id;
	 @NotNull(message = "StartDate should not be null")
	 private LocalDate startDate;
	
	 private LocalDate endDate;
	
	 private User user;
	
	 private Hotel hotel;
	
	 private CarRental carRental;
	 
	
}
