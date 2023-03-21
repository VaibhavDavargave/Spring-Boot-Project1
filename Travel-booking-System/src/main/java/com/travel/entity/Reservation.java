package com.travel.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ReservationTable")
@Getter
@Setter

@NoArgsConstructor
public class Reservation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "UserId" )
    private User user;

    

    @ManyToOne
    @JoinColumn(name = "HotelId")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "carId")
    private CarRental carRental;

    @Builder
	public Reservation(int id, LocalDate startDate, LocalDate endDate, User user, Hotel hotel, CarRental carRental) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.user = user;
		this.hotel = hotel;
		this.carRental = carRental;
	}
    
    

	
}
