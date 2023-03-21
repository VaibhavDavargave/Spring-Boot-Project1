package com.travel.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.entity.CarRental;

public interface CarRentalRepository extends JpaRepository<CarRental, Integer> {

	List<CarRental> findByCompanyName(String companyName);
		
		List<CarRental> findByCarModel(String carModel);
		

	
	
	
	
	
}
