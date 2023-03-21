package com.travel.convertor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.travel.entity.User;
import com.travel.model.UserDTO;

@Component
public class Converter {
	
	//converts from user entity to userDTO

		public UserDTO convertEntityToUserDTO(User user) {
			UserDTO userDTO = new UserDTO();
			if(user!=null)
			{
				BeanUtils.copyProperties(user, userDTO);
			}
			return userDTO;
		}
		//converts from userDTO to user entity
		public User  convertDTOToUser(UserDTO userDTO)
		{
			User user = new User();
			if(userDTO!= null) {
				BeanUtils.copyProperties(userDTO, user);
				
			}
			return user;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

