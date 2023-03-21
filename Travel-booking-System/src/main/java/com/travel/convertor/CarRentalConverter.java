package com.travel.convertor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.travel.entity.CarRental;

import com.travel.model.CarRentalDTO;


@Component
public class CarRentalConverter {

	//converts from carrentalConverter  entity to carrentalDTO
	public CarRentalDTO convertEntityToCarRentalConverter(CarRental car) {
		CarRentalDTO carDTO = new CarRentalDTO();
		if(car!=null)
		{
			BeanUtils.copyProperties(car, carDTO);
		}
		return carDTO;
	}
	
	//converts from carrentalDTO to car rental entity
	public CarRental  convertDTOToCarRental(CarRentalDTO carDTO)
	{
		CarRental car = new CarRental();
		if(carDTO!= null) {
			BeanUtils.copyProperties(carDTO, car);
			
		}
		return car;
	}
}
