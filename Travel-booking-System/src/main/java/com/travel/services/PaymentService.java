package com.travel.services;

import java.util.List;
import com.travel.entity.Payment;
import com.travel.model.PaymentDTO;





public interface PaymentService {

	
	String createPayment(Payment pay, int reservationid, int userid);
	
	PaymentDTO  getPaymentById(int id);
	
	List<PaymentDTO> getAllPayment();
	
	PaymentDTO updatePayment(int id, Payment pay);
	
	String deletePaymentById(int id);
	
	void deleteAllPayments();
	
	List<PaymentDTO> getPaymentByDate(String date);

	

	
}
