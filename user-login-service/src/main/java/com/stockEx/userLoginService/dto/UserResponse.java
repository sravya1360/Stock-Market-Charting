package com.stockEx.userLoginService.dto;

public class UserResponse {
	private Integer userId;
	private String userName;
	private String email;
	private Long mobileNum;
	private Boolean confirmed;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}
	public Boolean getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}
	public UserResponse(Integer userId, String userName, String email, Long mobileNum, Boolean confirmed) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.mobileNum = mobileNum;
		this.confirmed = confirmed;
	}
	public UserResponse() {
		super();
	}
	
	

}
