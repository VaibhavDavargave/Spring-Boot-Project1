package com.travel.entity;

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
@Table(name="HotelTable")
@Getter
@Setter

@NoArgsConstructor
@ToString
public class Hotel {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int HotelId;

	    @Column(length= 20, name="Hotelname")
	    private String name;

	    @Column(length= 100, name="HotelAddress")
	    private String address;

	    @Column(length= 50, name="CityName")
	    private String city;

	    @Column(length= 50, name="HotelRooms")
	    private int numberOfRooms;

	    @Column(length= 50, name="PricePerNight")
	    private double pricePerNight;

	    @Builder
		public Hotel(int hotelId, String name, String address, String city, int numberOfRooms, double pricePerNight) {
			super();
			HotelId = hotelId;
			this.name = name;
			this.address = address;
			this.city = city;
			this.numberOfRooms = numberOfRooms;
			this.pricePerNight = pricePerNight;
		}
	    
	    

}
