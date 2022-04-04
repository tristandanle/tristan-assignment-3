package com.coderscampus.assignment3;

import java.util.Scanner;

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

	public String inputUsername(String username2) {
		System.out.println();
		System.out.println("Enter your email: ");
		System.out.println(" ");
		String username = null;
		// boolean valide = true;
		// do {

		username = scanner().nextLine();
		// if (!(username.equalsIgnoreCase(username2))){

		System.out.println(" ");
		// System.out.println("NO MATCH");
		// System.out.println(" ");
		// System.out.println("Enter your email: ");
		// System.out.println(" ");
		// } else {
		// valide = false;
		// }
		// }
		// while(valide == true);
		return username;
	}// End method inputUsername()

	public String inputPassword(String password2) {
		// System.out.println();
		System.out.println("Enter your password: ");
		System.out.println(" ");
		String password = null;
		// boolean valide = true;
		// do {
		password = scanner().nextLine();
		// if (!(password.equals(password2))){
		System.out.println(" ");
		// System.out.println("NO MATCH");
		// System.out.println(" ");
		// System.out.println("Enter your password: ");
		// System.out.println(" ");
		// } else {
		// valide = false;
		// }
		// }
		// while(valide == true);
		return password;
	}// End method inputPassword()

	public boolean validateUser(User user) {
		int MAX_ATTEMPT = 5;
		String name;
		boolean flag = false;
		boolean valid = false;
		String password;
		String username;

		for (int i = 0; i < MAX_ATTEMPT; i++) {
			username = inputUsername(user.getUserName());
			password = inputPassword(user.getPassword());
			if ((user.getUserName().equalsIgnoreCase(username)) && (user.getPassword().equals(password))) {
				flag = true;
				// valid = true;
				break;
			} else {
				// System.out.println();
				if (i < (MAX_ATTEMPT - 1)) {
					System.out.println("Invalid login, please try again");
				}
			}
		} // End for loop

		return flag;
	} // End method validateUser()
} // End Class
