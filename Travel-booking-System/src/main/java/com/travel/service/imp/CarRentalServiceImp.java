package com.travel.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.convertor.CarRentalConverter;
import com.travel.entity.CarRental;
import com.travel.exception.ResourceNotFoundException;
import com.travel.model.CarRentalDTO;
import com.travel.repositiory.CarRentalRepository;
import com.travel.services.CarRentalService;

@Service
public class CarRentalServiceImp implements CarRentalService{
     @Autowired
	private CarRentalRepository carrepository;
	@Autowired
	private CarRentalConverter  carconverter;
	
	
	
	@Override
	public String createCarRental(CarRental car) {
		String message=null;
		
		car.setCompanyName(car.getCompanyName());
		car.setCarModel(car.getCarModel());
		car.setPickupLocation(car.getPickupLocation());
		car.setDropoffLocation(car.getDropoffLocation());
		car.setPickupDate(car.getPickupDate());
		car.setDropoffDate(car.getDropoffDate());
		car.setPricePerDay(car.getPricePerDay());
		
		carrepository.save(car);
	
		if(car != null)
			
		{
			message = " details added successfully!!";
		}
	
	return message;
	}

	
	
	@Override
	public CarRentalDTO getCarRentalById(int id) {
		CarRental car =carrepository.findById(id).get();
		
		return carconverter.convertEntityToCarRentalConverter(car);
	}
	
	
	
	

	@Override
	public List<CarRentalDTO> getAllCarRental() {
		List<CarRental> car=carrepository.findAll();
		List<CarRentalDTO> carDTO = new ArrayList<>();
		
		for(CarRental c:car) {
			carDTO.add(carconverter.convertEntityToCarRentalConverter(c));
		}
		
		
		return carDTO;
	}

	@Override
	public CarRentalDTO updateCarRental(int id, CarRental car) {
		CarRental ext =carrepository.findById(id).get();
		
		ext.setCompanyName(car.getCompanyName());
		ext.setCarModel(car.getCarModel());
		ext.setPickupLocation(car.getPickupLocation());
		ext.setDropoffLocation(car.getDropoffLocation());
		ext.setPickupDate(car.getPickupDate());
		ext.setDropoffDate(car.getDropoffDate());
		ext.setPricePerDay(car.getPricePerDay());
		
		carrepository.save(ext);
		return carconverter.convertEntityToCarRentalConverter(ext);
	}
	
	@Override
	public String deleteCarRentalById(int id) throws ResourceNotFoundException {
		String msg=null;
		Optional<CarRental> carRental = carrepository.findById(id);
		if(carRental.isPresent())
		{
			carrepository.deleteById(id);
			
			msg= "Car deleted successfully!";
		}
		else
		{
			
			throw new ResourceNotFoundException("CarRental", "Id", id);
		}
		return msg;
		
	}



	@Override
	public void deleteAllCarRental() {
		carrepository.deleteAll();
		
	}


    @Override
	public List<CarRentalDTO> getCarRentalByCompanyName(String CompanyName) {
		
		List<CarRental> car=carrepository.findByCompanyName(CompanyName);
		List<CarRentalDTO> carsDTO= new ArrayList<>();
		for(CarRental c: car)
		{
			carsDTO.add(carconverter.convertEntityToCarRentalConverter(c));
		}
		return carsDTO;
	}



	@Override
	public List<CarRentalDTO> getCarRentalByCarModel(String CarModel) {
		List<CarRental> car1=carrepository.findByCarModel(CarModel);
		List<CarRentalDTO> carsDTO = new ArrayList<>();
		for(CarRental c:car1)
		{
			carsDTO.add(carconverter.convertEntityToCarRentalConverter(c));
		}
		return carsDTO;
	}

}
