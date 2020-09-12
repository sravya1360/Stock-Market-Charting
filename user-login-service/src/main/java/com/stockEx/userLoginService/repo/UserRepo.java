package com.stockEx.userLoginService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockEx.userLoginService.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	User findByMobileNum(Long mobileNum);

}
