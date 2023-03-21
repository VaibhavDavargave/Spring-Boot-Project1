package com.travel.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="CarRentalTable")
@Getter
@Setter

@NoArgsConstructor
@ToString
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CarId;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String carModel;


    @Column(name = "pickup_location")
    private String pickupLocation;

  
    @Column(name = "dropoff_location")
    private String dropoffLocation;

    @Column(nullable = false)
    private LocalDate pickupDate;  

    @Column(nullable = false)
    private LocalDate dropoffDate;

    @Column(nullable = false)
    private double pricePerDay;

    @Builder
	public CarRental(int carId, String companyName, String carModel, String pickupLocation, String dropoffLocation,
			LocalDate pickupDate, LocalDate dropoffDate, double pricePerDay) {
		super();
		CarId = carId;
		this.companyName = companyName;
		this.carModel = carModel;
		this.pickupLocation = pickupLocation;
		this.dropoffLocation = dropoffLocation;
		this.pickupDate = pickupDate;
		this.dropoffDate = dropoffDate;
		this.pricePerDay = pricePerDay;
	}

    
	
    
    
    
    
    

}
