package com.travel.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDTO {
	 private int HotelId;
	 @NotNull(message = "Hotel Name should not be null")
	 private String name;
	 @NotNull(message = "Address should not be null")
	 private String address;
	 @NotNull(message = "City should not be null")
	 private String city;
	
	 private int numberOfRooms;
	
	 private double pricePerNight;

	 
}
