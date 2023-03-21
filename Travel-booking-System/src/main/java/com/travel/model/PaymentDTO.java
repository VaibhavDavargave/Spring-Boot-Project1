package com.travel.model;

import java.time.LocalDate;
import java.util.Date;

import com.travel.entity.Reservation;
import com.travel.entity.User;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {

	 private int id;
	 @NotNull(message = "Amount should not be null")
	 private double amount;
	 @NotNull(message = "Payment Date should not be null")
	 private LocalDate paymentDate;
	
	 private User user;
	
	 private Reservation reservation;
	 
}
