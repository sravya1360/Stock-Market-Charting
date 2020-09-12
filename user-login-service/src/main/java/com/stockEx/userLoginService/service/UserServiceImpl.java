package com.stockEx.userLoginService.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockEx.userLoginService.dto.UserResponse;
import com.stockEx.userLoginService.entity.User;
import com.stockEx.userLoginService.repo.UserRepo;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepo userRepo;
	private ModelMapper modelMapper;

	public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
		super();
		this.userRepo = userRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<UserResponse> findAllUsers() {
		Type listType = new TypeToken<List<UserResponse>>() {
		}.getType();
		return modelMapper.map(userRepo.findAll(), listType);

	}

	@Override
	public UserResponse findUserById(Integer id) {

		return modelMapper.map(userRepo.findById(id), UserResponse.class);
	}

	@Override
	public UserResponse findUserByEmail(String email) {

		return modelMapper.map(userRepo.findByEmail(email), UserResponse.class);
	}

	@Override
	public UserResponse findUserByMobileNum(Long mobileNum) {

		return modelMapper.map(userRepo.findByMobileNum(mobileNum), UserResponse.class);
	}

	@Override
	public UserResponse addUser(User userDetails) {
		
		User user = userRepo.save(userDetails);
		return modelMapper.map(user, UserResponse.class);
	}

	@Override
	public UserResponse updateUser(User userDetails, Integer id) {
		
		Optional<User> optionalUser = userRepo.findById(id);
		if (!optionalUser.isPresent()) {
			userRepo.save(userDetails);
			UserResponse userResponse = modelMapper.map(userDetails, UserResponse.class);
			return userResponse;
		}
		userRepo.deleteById(id);
		userRepo.save(userDetails);
		UserResponse userResponse = modelMapper.map(userDetails, UserResponse.class);
		return userResponse;
		

	}

}
