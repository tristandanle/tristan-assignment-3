package com.coderscampus.userloginapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
        int MAX_USERS = 4;
		BufferedReader fileReader = null;
		UserService userService = new UserService();
		User[] users = new User[MAX_USERS];
		try {
			
			fileReader = new BufferedReader(new FileReader("./data.txt"));
		
			String line;
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				
				users[i] = userService.createUser(line);
				i += 1;
			}
			
			int j = 0;
			for (User user : users) {

				System.out.println();
				System.out.println("User#" + (j += 1) + ": " + user.getName());
				System.out.println("*".repeat(17));
				boolean valid = userService.validateUser(user);

				if (valid) {
					System.out.println();
					System.out.println("Welcome: " + user.getName());
					System.out.println();
				} else {
					System.out.println("Too many failed login attempts, you are now locked out.");
					System.out.println();
				}
			} //End for loop		

		} catch (FileNotFoundException e) {
			System.out.println("The file wasn't found ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There is an I/O Exception");
			e.printStackTrace();
		} finally {
			try {
				//System.out.println("Closing file reader");
				fileReader.close();
			} catch (IOException e) {
				System.out.println("The file is not closing");
				e.printStackTrace();
			}

		}

	}

}
