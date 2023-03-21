package com.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.convertor.CarRentalConverter;
import com.travel.entity.CarRental;
import com.travel.model.CarRentalDTO;
import com.travel.services.CarRentalService;

@RestController
@RequestMapping("/CarRental")
public class CarRentalController {
	@Autowired
	private CarRentalService carservice;
	@Autowired
	private CarRentalConverter carconverter;
	
	
	@PostMapping("/createCarrental")
	public String createCarRental(@RequestBody CarRentalDTO carDTO)
	{
		final CarRental car = carconverter.convertDTOToCarRental(carDTO);
		return carservice.createCarRental(car);
		
	}
	
	@GetMapping("/getCarrentalById/{id}")
	public CarRentalDTO getCarRentalById(@PathVariable("id")int id)
	{
		return carservice.getCarRentalById(id);
	}
	
	@GetMapping("/getAllcarrental")
	public List<CarRentalDTO> getAllCarRental(){
		return carservice.getAllCarRental();
	}
	
	@PutMapping("/updatecarrental/{id}")
	public CarRentalDTO updateCarRental(@PathVariable("id") int id,
			@RequestBody CarRentalDTO carDTO) {
		CarRental car1 = carconverter.convertDTOToCarRental(carDTO);
		return carservice.updateCarRental(id , car1);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteCarRentalById(@PathVariable("id") int id)
	{
		return carservice.deleteCarRentalById(id);
	}
	
	@DeleteMapping("/deleteAllCarRental")
	public ResponseEntity<String> deleteAllCarRental()
	{
		carservice.deleteAllCarRental();
		return new ResponseEntity<String>("All CarRental details got deleted!",
				HttpStatus.OK);
	}
	
	@GetMapping("/getCarRentalByCompanyName/{name}")
	public List<CarRentalDTO> getCarRentalByCompanyName(@PathVariable("name") String CompanyName)
	{
		return carservice.getCarRentalByCompanyName(CompanyName);
	}
	
	@GetMapping("/getCarRentalByCarModel/{name}")
	public List<CarRentalDTO> getCarRentalByCarModel(@PathVariable("name") String CarModel)
	{
		return carservice.getCarRentalByCarModel(CarModel);
	}

}
