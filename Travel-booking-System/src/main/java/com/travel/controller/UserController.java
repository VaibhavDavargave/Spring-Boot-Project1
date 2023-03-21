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
import com.travel.convertor.Converter;
import com.travel.entity.User;
import com.travel.model.UserDTO;
import com.travel.services.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
private UserService userService;
	
	@Autowired
	private Converter converter;
	
	@PostMapping("/createUser")
	public String createUser(@RequestBody UserDTO userDTO)
	{
		final User user = converter.convertDTOToUser(userDTO);
		return userService.createUser(user);
		
	}
	
	@GetMapping("/getuserById/{id}")
	public UserDTO getUserById(@PathVariable("id")int id)
	{
		return userService.getUserById(id);
	}
	
	@GetMapping("/getAllUser")
	public List<UserDTO> getAllUser(){
		return userService.getAllUser();
	}
	
	@PutMapping("/updateUser/{id}")
	public UserDTO updateUser(@PathVariable("id") int id,
			@RequestBody UserDTO userDTO) {
		User user1 = converter.convertDTOToUser(userDTO);
		return userService.updateUser(id , user1);
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public String deletePaymentById(@PathVariable("id") int id)
	{
		return userService.deleteUserById(id);
	}
	
	@DeleteMapping("/deleteAllUsers")
	public ResponseEntity<String> deleteAllUsers()
	{
		userService.deleteAllUsers();
		return new ResponseEntity<String>("All user details got deleted!",
				HttpStatus.OK);
	}
	
	@GetMapping("/getUserByName/{name}")
	public List<UserDTO> getUserByName(@PathVariable("name") String UserName)
	{
		return userService.getUserByName(UserName);
	}
	
	
	}
	
