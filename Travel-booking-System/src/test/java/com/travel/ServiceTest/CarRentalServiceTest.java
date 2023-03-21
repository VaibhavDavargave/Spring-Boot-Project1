package com.travel.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.travel.convertor.CarRentalConverter;
import com.travel.entity.CarRental;
import com.travel.model.CarRentalDTO;
import com.travel.repositiory.CarRentalRepository;
import com.travel.services.CarRentalService;

@SpringBootTest
public class CarRentalServiceTest {
	
	@Autowired
	private CarRentalService carRentalService;
	
	@Autowired
	private CarRentalConverter carRentalConverter;
	
	@MockBean
	private  CarRentalRepository carrentalRepository; 
	
	@Test
	void testCreateCarRental()
	{
		CarRental carRental = CarRental.builder().companyName("Audi").carModel("A4").pickupLocation("pune").dropoffLocation("mumbai").pickupDate(LocalDate.of(2023,03,020)).dropoffDate(LocalDate.of(2023, 03, 22)).pricePerDay(2000.40).build();
		
		Mockito.when(carrentalRepository.save(carRental)).thenReturn(carRental);
		assertEquals(" details added successfully!!", carRentalService.createCarRental(carRental));
		assertThat(carRentalService.createCarRental(carRental)).isEqualTo(" details added successfully!!");
		
	}
	
	@Test
	void testGetCarRentalById()
	{
		CarRental carrental1 = CarRental.builder().carId(3).companyName("tata").carModel("Nexon").pickupLocation("Pune").dropoffLocation("Alandi").pickupDate(LocalDate.of(2023,03,020)).dropoffDate(LocalDate.of(2023, 03, 22)).pricePerDay(2000.40).build();
		
		Mockito.when(carrentalRepository.save(carrental1)).thenReturn(carrental1);
		assertEquals("Nexon", carrental1.getCarModel());
	}
	
	@Test
	void testGetAllCarRentals()
	{
		CarRental carrental = CarRental.builder().companyName("tata").carModel("Nexon").pickupLocation("Pune").dropoffLocation("Alandi").pickupDate(LocalDate.of(2023,03,020)).dropoffDate(LocalDate.of(2023, 03, 22)).pricePerDay(2000.40).build();
		
		CarRental carRental1 = CarRental.builder().companyName("Audi").carModel("A4").pickupLocation("pune").dropoffLocation("mumbai").pickupDate(LocalDate.of(2023,03,020)).dropoffDate(LocalDate.of(2023, 03, 22)).pricePerDay(2000.40).build();
		
		List<CarRental> list = new ArrayList<>();
		list.add(carrental);
		list.add(carRental1);
		
		Mockito.when(carrentalRepository.findAll()).thenReturn(list);
		
		List<CarRentalDTO> dto = carRentalService.getAllCarRental();
		
		List<CarRental> carrentals = new ArrayList<CarRental>();
		dto.forEach(carrentalDto->
		carrentals.add(carRentalConverter.convertDTOToCarRental(carrentalDto)));
		
		assertThat(carrentals.get(0).getCompanyName()).isEqualTo(list.get(0).getCompanyName());
		
	}
	
	@Test
	void testUpdateCarRental()
	{
		CarRental carrental = CarRental.builder().companyName("tata").carModel("Nexon").pickupLocation("Pune").dropoffLocation("Alandi").pickupDate(LocalDate.of(2023,03,020)).dropoffDate(LocalDate.of(2023, 03, 22)).pricePerDay(2000.40).build();
		
		Optional<CarRental> opCarRental = Optional.of(carrental); 
		
		Mockito.when(carrentalRepository.findById(carrental.getCarId())).thenReturn(opCarRental);
		
		CarRental c = opCarRental.get();
		carrental.setCompanyName("mahindra");
		
		Mockito.when(carrentalRepository.save(carrental)).thenReturn(c);
		
		CarRentalDTO dto = carRentalService.updateCarRental(carrental.getCarId(), carrental);
		assertEquals(dto.getCompanyName(), c.getCompanyName());
		
	}

}
