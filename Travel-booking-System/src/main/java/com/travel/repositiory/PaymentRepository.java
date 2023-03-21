package com.travel.repositiory;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.entity.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	List<Payment> findByUser(String user);
	//List<Payment> findByPayment(Payment pay);

	
	
}
