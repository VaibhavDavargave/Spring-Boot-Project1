package com.travel.service.imp;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.convertor.PaymentConverter;
import com.travel.entity.Payment;
import com.travel.entity.Reservation;
import com.travel.entity.User;
import com.travel.exception.ResourceNotFoundException;
import com.travel.model.PaymentDTO;
import com.travel.repositiory.PaymentRepository;
import com.travel.repositiory.ReservationRepository;
import com.travel.repositiory.UserRepository;
import com.travel.services.PaymentService;
@Service
public  class PaymentServiceImp implements PaymentService{

	
	@Autowired
	private PaymentRepository paymentrepository;
	@Autowired
	private PaymentConverter paymentconverter;

	@Autowired
	private ReservationRepository resv;

	@Autowired
	private UserRepository user;
	
	@Override
	public String createPayment(Payment pay,int reservationid,int userid) {
		String message=null;
		
	Reservation res	=resv.findById(reservationid).get();
	  User us  = user.findById(userid).get();
		pay.setReservation(res);
		pay.setUser(us);
		
		paymentrepository.save(pay);
		
		if(pay != null)
					
				{
					message = " details added successfully!!";
				}
			
			return message;
		
		
		
		
	}
	
	
	
	

	@Override
	public PaymentDTO getPaymentById(int id) {
		Payment pay = paymentrepository.findById(id).get();
		return paymentconverter.convertEntityToPaymentConverter(pay);
	}

	@Override
	public List<PaymentDTO> getAllPayment() {
		
		List<Payment> pay=paymentrepository.findAll();
		List<PaymentDTO> payDTO = new ArrayList<>();
		
		for(Payment p:pay) {
			payDTO.add(paymentconverter.convertEntityToPaymentConverter(p));
			
		}
	
		return payDTO;
	}

	@Override
	public PaymentDTO updatePayment(int id, Payment pay) {
		Payment ext = paymentrepository.findById(id).get();
		ext.setAmount(pay.getAmount());
		ext.setPaymentDate(pay.getPaymentDate());
		ext.setUser(pay.getUser());
		ext.setReservation(pay.getReservation());
		
		paymentrepository.save(ext);
		
		return paymentconverter.convertEntityToPaymentConverter(ext);
	}

	@Override
	public String deletePaymentById(int id) throws ResourceNotFoundException {
		String msg = null;
		Optional<Payment> payment=paymentrepository.findById(id);
		if(payment.isPresent())
		{
			paymentrepository.deleteById(id);
			msg="Payment details deleted successfully";
		}
		else
		{
			throw new ResourceNotFoundException("Payment", "Id", id);
		}
		return msg;
		
	}

	@Override
	public void deleteAllPayments() {
		paymentrepository.deleteAll();
		
	}

	@Override
	public List<PaymentDTO> getPaymentByDate(String paymentDate ) {
		List<Payment> payment1=paymentrepository.findAll();
		List<PaymentDTO> paymentsDTO= new ArrayList<>();
		for(Payment p: payment1)
		{
			paymentsDTO.add(paymentconverter.convertEntityToPaymentConverter(p));
		}
		return paymentsDTO;
	}

	

}
