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
				// users[i] = userService.createUser(line);
				// System.out.println(line);
				String[] stringArray = line.split(",");
				User user = new User();
				user.setUserName(stringArray[0]);
				user.setPassword(stringArray[1]);
				user.setName(stringArray[2]);
				users[i] = user;
				i++;
				// System.out.println(user.getUserName() + user.getPassword() + user.getName());

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

}

