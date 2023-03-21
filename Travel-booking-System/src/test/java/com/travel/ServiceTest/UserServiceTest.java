package com.travel.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.travel.convertor.Converter;
import com.travel.entity.User;
import com.travel.model.UserDTO;
import com.travel.repositiory.UserRepository;
import com.travel.services.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private Converter converter;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	void testCreateUser()
	{
		User user = User.builder().userName("vaibhav").email("vaibhav@gmail.com").password("vaibhav").
				build();
		
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertEquals("User details added successfully!!", userService.createUser(user));
		assertThat(userService.createUser(user)).isEqualTo("User details added successfully!!");
	}
	
	@Test
	void testGetUserById()
	{
		User user1 = User.builder().userId(3).userName("rohit").email("rohit@gmail.com").password("rohit").build();
		
		Mockito.when(userRepository.save(user1)).thenReturn(user1);
		assertEquals("rohit",user1.getUserName());
	}
	
	@Test
	void testGetAllUsers()
	{
		User user = User.builder().userId(4).userName("vaibhav").email("vaibhav@gmail.com").password("vaibhav").build();
		
		User user1 = User.builder().userId(5).userName("Rutwik").email("rutwik@gmail.com").password("rutwik").build();
		
		List<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user);
		
		Mockito.when(userRepository.findAll()).thenReturn(list);
		
		List<UserDTO> dto = userService.getAllUser();
		
		List<User> users= new ArrayList<User>();
		dto.forEach(userDto->
		users.add(converter.convertDTOToUser(userDto)));
		
		assertThat(users.get(0).getUserName()).isEqualTo(list.get(0).getUserName());
				
	}
	
	@Test
	void testUpdateUser()
	{
		User user = User.builder().userName("vaibhav").email("vaibhav@gmail.com").password("vaibhav").build();
		
		Optional<User> opUser = Optional.of(user);
		
		Mockito.when(userRepository.findById(user.getUserId())).thenReturn(opUser);
		
		User u = opUser.get();
		user.setUserName("vaishali");
		
		Mockito.when(userRepository.save(user)).thenReturn(u);
		
		UserDTO dto = userService.updateUser(user.getUserId(), user);
		assertEquals(dto.getUserName(), u.getUserName());
	}
	
	
	
	 

	}
