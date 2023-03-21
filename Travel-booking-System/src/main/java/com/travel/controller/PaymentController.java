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

import com.travel.convertor.PaymentConverter;
import com.travel.entity.Payment;
import com.travel.model.PaymentDTO;
import com.travel.services.PaymentService;

@RestController
@RequestMapping("/Payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentservice;
	@Autowired
	private PaymentConverter paymentconverter;
	
	@PostMapping("/createpayment/{reservation}/{user}")
	public String createPayment(@RequestBody PaymentDTO payDTO,@PathVariable ("reservation") int reservationid,
	@PathVariable ("user") int userid)
	{
		final Payment pay = paymentconverter.convertDTOToPayment(payDTO);
		return paymentservice.createPayment(pay,reservationid,userid);
		
	}
	
	@GetMapping("/getpaymentById/{id}")
	public PaymentDTO getPaymentById(@PathVariable("id")int id)
	{
		return paymentservice.getPaymentById(id);
	}
	
	@GetMapping("/getAllpayment")
	public List<PaymentDTO> getAllPayment(){
		return paymentservice.getAllPayment();
	}
	
	@PutMapping("/updatepayment/{id}")
	public PaymentDTO updatePayment(@PathVariable("id") int id,
			@RequestBody PaymentDTO payDTO) {
		Payment pay1 = paymentconverter.convertDTOToPayment(payDTO);
		return paymentservice.updatePayment(id, pay1);
	}
	
	@DeleteMapping("/deletePaymentById/{id}")
	public String deletePaymentById(@PathVariable("id") int id)
	{
		return paymentservice.deletePaymentById(id);
	}
	
	@DeleteMapping("/deleteAllPayments")
	public ResponseEntity<String> deleteAllPayments()
	{
		paymentservice.deleteAllPayments();
		return new ResponseEntity<String>("All Payment details got deleted!",
				HttpStatus.OK);
	}
	
	@GetMapping("/getPaymentByDate/{paymentDate}")
	public List<PaymentDTO> getPaymentByDate(@PathVariable("paymentDate") String paymentDate)
	{
		return paymentservice.getPaymentByDate(paymentDate);
	}
}
