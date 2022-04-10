package com.coderscampus.assignment3;

import java.util.Scanner;

public interface UserService {
	public User[] loadUser(String fileName);
	public String inputUsername();	
	public String inputPassword();
	//public boolean validateUser(User[] user, String inUser, String inPassword);
	public boolean validateUser(User user);

}	
	
