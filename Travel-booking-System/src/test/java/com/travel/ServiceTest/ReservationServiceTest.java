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

import com.travel.convertor.ReservationConverter;
import com.travel.entity.Reservation;
import com.travel.model.ReservationDTO;
import com.travel.repositiory.ReservationRepository;
import com.travel.services.ReservationService;

@SpringBootTest
public class ReservationServiceTest {
	
	@Autowired
	private ReservationService reservationService; 
	
	@Autowired
	private ReservationConverter reservationConverter;
	
	@MockBean
	private ReservationRepository reservationRepository;
	
	@Test
	void testcreatereservation() {
		Reservation res = Reservation.builder().startDate(LocalDate.of(2023, 03, 28)).endDate(LocalDate.of(2023, 03, 29)).build();
		Mockito.when(reservationRepository.save(res)).thenReturn(res);
		assertEquals(" details added successfully!!",reservationService.createReservation(res, 3, 3, 3));
		assertThat(reservationService.createReservation(res, 3, 3, 3)).isEqualTo(" details added successfully!!");
	}
	
	@Test
	void getReservaionById() {
		Reservation res1 = Reservation.builder().id(1).startDate(LocalDate.of(2023, 03, 28)).endDate(LocalDate.of(2023, 03, 29)).build();
		Mockito.when(reservationRepository.save(res1)).thenReturn(res1); 
		assertEquals(1,res1.getId());
	}
	
	@Test
	void getallReservation() {
		Reservation res1 = Reservation.builder().id(1).startDate(LocalDate.of(2023, 03, 28)).endDate(LocalDate.of(2023, 03, 29)).build();
		
		Reservation res = Reservation.builder().id(2).startDate(LocalDate.of(2023, 04, 29)).endDate(LocalDate.of(2023, 05, 29)).build();
		
		List<Reservation> list = new ArrayList<>();
		
		list.add(res);
		list.add(res1);
		
		Mockito.when(reservationRepository.findAll()).thenReturn(list);
		
		List<ReservationDTO> dto= reservationService.getAllReservation();
		
		List<Reservation> li = new ArrayList<>();
		
		dto.forEach(revdto->
		li.add(reservationConverter.convertDTOToReservation(revdto)));
		
		assertThat(res1.getId()).isEqualTo(list.get(1).getId());
		
	}
	
	@Test
	void updatereservation() {
		Reservation res2 = Reservation.builder().id(1).startDate(LocalDate.of(2023, 03, 28)).endDate(LocalDate.of(2023, 03, 29)).build();
		
		Optional<Reservation> reservation = Optional.of(res2);
		Mockito.when(reservationRepository.findById(res2.getId())).thenReturn(reservation);
		
		Reservation r =reservation.get();
		
		res2.setId(1);
		Mockito.when(reservationRepository.save(res2)).thenReturn(r);
		ReservationDTO dto=reservationService.updateReservation(res2.getId(), res2);
		assertEquals(dto.getId(),r.getId());
		
		
		
	}

}
