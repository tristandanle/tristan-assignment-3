package com.coderscampus.userloginapp;

public class User {

	private String userName;
	private String password;
	private String name;

	public User() {
		// System.out.println("User is created");
	}

//	public User(String userName, String password, String name) {
//		super();
//		this.userName = userName;
//		this.password = password;
//		this.name = name;
//	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
