package com.coderscampus.userloginapp;

import java.util.Scanner;
import com.coderscampus.userloginapp.User;

public class UserService {

	public User createUser(String line) {

		User user = new User();
		String[] stringArray = line.split(",");

		user.setUserName(stringArray[0]);
		user.setPassword(stringArray[1]);
		user.setName(stringArray[2]);
		return user;
	} // End method createUser()

	public Scanner scanner() {
		Scanner scan = new Scanner(System.in);
		return scan;
	}// End method scanner()

	public String inputUsername() {
		System.out.println();
		System.out.println("Enter your email: ");
		String username = scanner().nextLine();
		return username;
	}// End method inputUsername()
 

	public String inputPassword() {
		System.out.println();
		System.out.println("Enter your password: ");
		String password = scanner().nextLine();
		return password;
	}// End method inputPassword()

	public boolean validateUser(User user) {
		int MAX_ATTEMPT = 5;
		String name;		
		boolean flag = false;
		String password;
		String username;

		for (int i = 0; i < MAX_ATTEMPT; i++) {
			username = inputUsername();
			password = inputPassword();
			if ((user.getUserName().equals(username)) && (user.getPassword().equals(password))) {
				flag = true;
				break;
			} else {
				System.out.println();
				if(i < (MAX_ATTEMPT - 1)) {
				System.out.println("Invalid login, please try again");
				}
			}
		} // End for loop

		return flag;
	} // End method validateUser()
} // End Class
