package com.travel.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PaymentTable")
@Getter
@Setter

@NoArgsConstructor
public class Payment {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(nullable = false)
	    private double amount;

	    @Column(nullable = false)
	    private LocalDate paymentDate;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

	    @ManyToOne
	    @JoinColumn(name = "reservation_id")
	    private Reservation reservation;

	    @Builder
		public Payment(int id, double amount, LocalDate paymentDate, User user, Reservation reservation) {
			super();
			this.id = id;
			this.amount = amount;
			this.paymentDate = paymentDate;
			this.user = user;
			this.reservation = reservation;
		}
	    
	    
}
