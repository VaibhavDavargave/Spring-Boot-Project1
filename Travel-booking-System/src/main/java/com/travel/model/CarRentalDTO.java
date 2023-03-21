package com.travel.model;

import java.time.LocalDate;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRentalDTO {
	 private int CarId;
	 @NotNull(message = "Company Name should not be null")
	 private String companyName;
	 @NotNull(message = "Car Model should not be null")
	 private String carModel;
	 
	 private String pickupLocation;
	
	 private String dropoffLocation;
	
	 private LocalDate pickupDate;  
	
	  private LocalDate dropoffDate;
	
	  private double pricePerDay;

}
