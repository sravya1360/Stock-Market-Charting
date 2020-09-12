package com.stockEx.userLoginService.service;

import java.util.List;

import com.stockEx.userLoginService.dto.UserResponse;
import com.stockEx.userLoginService.entity.User;

public interface UserService {
	
	List<UserResponse> findAllUsers();
	UserResponse findUserById(Integer id);
	UserResponse findUserByEmail(String email);
	UserResponse findUserByMobileNum(Long mobileNum);
	UserResponse addUser(User userDetails);
	UserResponse updateUser(User userDetails, Integer id);

}
