package com.stockEx.userLoginService.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.stockEx.userLoginService.dto.UserResponse;
import com.stockEx.userLoginService.entity.User;
import com.stockEx.userLoginService.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	UserService userService;
	ModelMapper modelMapper;
	public UserController(UserService userService, ModelMapper modelMapper) {
		super();
		this.userService = userService;
		this.modelMapper = modelMapper;
	}
	
	@GetMapping("/users/all")
	public ResponseEntity<List<UserResponse>> findAllUsers() {
		return ResponseEntity.status(HttpStatus.FOUND).body(userService.findAllUsers());
	}
	
	@GetMapping("/users/by-id/{id}")
	public ResponseEntity<UserResponse> findUserById(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.FOUND).body(userService.findUserById(id));
		
	}
	
	@GetMapping("/users/by-email/{email}")
	public ResponseEntity<UserResponse> findUserByEmail(@PathVariable String email){
		return ResponseEntity.status(HttpStatus.FOUND).body(userService.findUserByEmail(email));
		
	}
	
	@GetMapping("/users/by-mobileNum/{mobileNum}")
	public ResponseEntity<UserResponse> findUserByMobileNum(@PathVariable Long mobileNum){
		return ResponseEntity.status(HttpStatus.FOUND).body(userService.findUserByMobileNum(mobileNum));
		
	}
	
	@PostMapping("/users/addUser")
	public ResponseEntity<UserResponse> addUser(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
		
	}
	
	@PutMapping("/users/updateUser/by-id/{id}")
	public ResponseEntity<UserResponse> updateUser(@RequestBody User user, @PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(user,id));
    }
	
	
	
	
	
	

}
