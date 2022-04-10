package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserServiceImpl implements UserService {

	public User[] loadUser(String fileName) {
		BufferedReader fileReader = null;
		UserService userService = new UserServiceImpl();
		String inUser;
		String inPassword;
		
		User[] users = new User[4];
		int i = 0;
		try {

			fileReader = new BufferedReader(new FileReader(fileName));

			String line;
			while ((line = fileReader.readLine()) != null) {
				//users[i] = userService.createUser(line);
				//System.out.println(line);
				String[] stringArray = line.split(",");
				User user = new User();
				user.setUserName(stringArray[0]);
				user.setPassword(stringArray[1]);
				user.setName(stringArray[2]);
				users[i] = user;
				i ++;
				//System.out.println(user.getUserName() + user.getPassword() + user.getName());

			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("The file wasn't found ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There is an I/O Exception");
			e.printStackTrace();
		} finally {
			try {
				// System.out.println("Closing file reader");
				fileReader.close();
			} catch (IOException e) {
				System.out.println("The file is not closing");
				e.printStackTrace();
			}

		}
		
		return users;
	}

	@Override
	public String inputUsername() {
		System.out.println("Enter your email: ");
		System.out.println(" ");
		String username = null;
		Scanner scan = new Scanner(System.in);
		username = scan.nextLine();

		return username;

	}

	@Override
	public String inputPassword() {
		// System.out.println();
		System.out.println("Enter your password: ");
		System.out.println(" ");
		String password = null;
		Scanner scan = new Scanner(System.in);
		password = scan.nextLine();

		return password;
	}

	@Override
	public boolean validateUser(User user) {
		int MAX_ATTEMPT = 5;
		// String name;
		boolean isValid = true;
		// boolean valid = false;
		String password ;
		String username ;

		//for (int i = 0; i < MAX_ATTEMPT; i++) {
    
			System.out.println("Invalid login, please try again");
			username = inputUsername();
			password = inputPassword();
            
			if ( ((user.getUserName().equalsIgnoreCase(username)) 
					&& (user.getPassword().equals(password))) ) {
				isValid = true;
			
            } else {
            	isValid = false;
            }
//			if (i == MAX_ATTEMPT - 1) {
//				isValid = false;
//		    }
		
		
		// break;
        return isValid;
	}
}
