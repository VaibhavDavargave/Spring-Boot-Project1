package com.travel.services;

import java.util.List;
import com.travel.entity.User;
import com.travel.model.UserDTO;

public interface UserService {
	
String createUser(User user);
UserDTO  getUserById(int id);
List<UserDTO> getAllUser();
UserDTO updateUser(int id, User user);
String deleteUserById(int id);
void deleteAllUsers();
List<UserDTO> getUserByName(String userName);


}
