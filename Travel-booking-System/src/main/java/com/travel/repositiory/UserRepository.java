package com.travel.repositiory;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.travel.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User a where a.UserName like %:c%")
	
	List<User> findByUserName(@Param("c") String UserName);
	//Optional<User> findByUserName(String userName);
	
}
