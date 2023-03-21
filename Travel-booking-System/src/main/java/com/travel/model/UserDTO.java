package com.travel.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	private int UserId;
	@NotNull(message = "User Name should not be null")
	private String UserName;
	@NotNull(message = "Email should not be null")
	private String Email;
	@NotNull(message = "Password should not be null")
	private String Password;
}
