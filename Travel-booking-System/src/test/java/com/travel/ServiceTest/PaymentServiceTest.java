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

import com.travel.convertor.PaymentConverter;
import com.travel.entity.Payment;
import com.travel.model.PaymentDTO;
import com.travel.repositiory.PaymentRepository;
import com.travel.services.PaymentService;

@SpringBootTest
public class PaymentServiceTest {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PaymentConverter paymentConverter;
	
	@MockBean
	private PaymentRepository paymentRepository;
	
	@Test
	 void testCreatePayment()
	{
		Payment payment = Payment.builder().id(2).amount(20000.10).paymentDate(LocalDate.of(2023,03, 20)).build();
		
		Mockito.when(paymentRepository.save(payment)).thenReturn(payment);
		//assertEquals(" details added successfully!!", paymentService.createPayment(payment, 2, 4));
		
		assertThat(paymentService.createPayment(payment, 2, 4)).isEqualTo(" details added successfully!!");
		
		
	}
	
	@Test
	 void getPaymentById()
	 {
		 Payment payment1 = Payment.builder().id(3).amount(20000.10).paymentDate(LocalDate.of(2023,03, 21)).build();
		 
		 Mockito.when(paymentRepository.save(payment1)).thenReturn(payment1);
		 assertEquals(3,payment1.getId());
		 
	 }
	
	@Test
	void getallPayment() {
	 Payment payment1 = Payment.builder().id(2).amount(20000.10).paymentDate(LocalDate.of(2023,03, 20)).build();
		
		Payment payment = Payment.builder().id(3).amount(20000.10).paymentDate(LocalDate.of(2023,03, 21)).build();
		
		List<Payment> list = new ArrayList<>();
		
		list.add(payment1);
		list.add(payment);
		
		Mockito.when(paymentRepository.findAll()).thenReturn(list);
		
		List<PaymentDTO> dto= paymentService.getAllPayment();
		
		List<Payment> payments = new ArrayList<>();
		
		dto.forEach(paydto->
		payments.add(paymentConverter.convertDTOToPayment(paydto)));
		
		assertThat(payments.get(0).getId()).isEqualTo(list.get(0).getId());
		
	}
	
	@Test
	void updatepayment() {
		Payment payment = Payment.builder().id(3).amount(20000.10).paymentDate(LocalDate.of(2023,03, 21)).build();
		
		Optional<Payment> opPayment = Optional.of(payment);
		Mockito.when(paymentRepository.findById(payment.getId())).thenReturn(opPayment);
		
		Payment p =opPayment.get();
		
		payment.setId(3);
		Mockito.when(paymentRepository.save(payment)).thenReturn(p);
		PaymentDTO dto=paymentService.updatePayment(payment.getId(), payment);
		assertEquals(dto.getId(), p.getId() );
		
		
		
	}

	
	
}
