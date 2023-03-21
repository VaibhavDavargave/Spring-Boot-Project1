package com.travel.services;

import java.util.List;

import com.travel.entity.CarRental;
import com.travel.model.CarRentalDTO;

public interface CarRentalService {

	
String createCarRental(CarRental car);
	
	CarRentalDTO  getCarRentalById(int id);
	
	List<CarRentalDTO> getAllCarRental();
	
	CarRentalDTO updateCarRental(int id, CarRental car);
	
     String deleteCarRentalById(int id);
	
	void deleteAllCarRental();
	

	List<CarRentalDTO> getCarRentalByCompanyName(String CompanyName);
	
	List<CarRentalDTO> getCarRentalByCarModel(String CarModel);
}
