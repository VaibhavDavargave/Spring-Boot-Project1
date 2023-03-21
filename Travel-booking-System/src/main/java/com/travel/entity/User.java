
package com.travel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="UserTable")
@Getter
@Setter

@NoArgsConstructor
@ToString


public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UserId;
	
	@Column(length= 20, name="UserName")
	private String UserName;
	
	@Column(length= 50, name="Email")
	private String Email;
	
	@Column(length= 50, name="Password")
	private String Password;
	

@Builder
	public User(int userId, String userName, String email, String password)
	{
		super();
		UserId = userId;
		UserName = userName;
		Email = email;
		Password = password;
	}


	
	}
	
	
	
	
	
	


