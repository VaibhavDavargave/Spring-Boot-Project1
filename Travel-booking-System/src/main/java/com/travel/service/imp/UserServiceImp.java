package com.travel.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.convertor.Converter;
import com.travel.entity.User;
import com.travel.exception.ResourceNotFoundException;
import com.travel.model.UserDTO;
import com.travel.repositiory.UserRepository;
import com.travel.services.UserService;
@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Converter convertor;
	
	

	@Override
	public String createUser(User user) {
		String message=null;
		
		user.setUserId(user.getUserId());
		user.setUserName(user.getUserName());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		
		userRepository.save(user);
		if(user != null)
		
			{
				message = "User details added successfully!!";
			}
		
		return message;
	}

	@Override
	public UserDTO getUserById(int id) {
		User user =userRepository.findById(id).get();
		return convertor.convertEntityToUserDTO(user);
	}

	
	@Override
	public List<UserDTO> getAllUser() {
		List<User> user=userRepository.findAll();
		List<UserDTO> userDTO = new ArrayList<>();
		for(User u:user) {
			userDTO.add(convertor.convertEntityToUserDTO(u));
			
		}
		return userDTO;
		
	}

	@Override
	public UserDTO updateUser(int id, User user) {
		User existinguser=userRepository.findById(id).get();
		
		existinguser.setUserId(user.getUserId());
		existinguser.setUserName(user.getUserName());
		existinguser.setEmail(user.getEmail()
		);
		existinguser.setPassword(user.getPassword());
	
		
		userRepository.save(existinguser);
		
		
		
		return convertor.convertEntityToUserDTO(existinguser);
	}
	
	@Override
	public String deleteUserById(int id) throws ResourceNotFoundException
	{
		String msg=null;
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent())
		{
			userRepository.deleteById(id);
		    
			msg = "User deleted successfully!!";
			
		}
		else
		{
			
			throw new ResourceNotFoundException("User","Id", id);
		}
		return msg;
		
		
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
		
	}

	@Override
	public List<UserDTO> getUserByName(String userName) {
		List<User> user=userRepository.findByUserName(userName);
		List<UserDTO> usersDTO= new ArrayList<>();
		for(User u: user)
		{
			usersDTO.add(convertor.convertEntityToUserDTO(u));
		}
		return usersDTO;
		
		
	}
	
}
