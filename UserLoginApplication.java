package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {

		final int SIZE = 4;
		final int MAX_Attempts = 5;
		int num = 0;
		int i = 0;
		User[] users = new User[SIZE];
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		Scanner scanner = new Scanner(System.in);

		// Read users from file
		loadUsers(i, users, br);

		while (num < MAX_Attempts) {
			boolean isValid = true;
			// Scan infos from keyboard
			System.out.println("Enter your email: ");
			System.out.println();
			String inpUser = scanner.nextLine();
			System.out.println();
			System.out.println("Enter your password: ");
			System.out.println();
			String inpPass = scanner.nextLine();

			for (User user : users) {
				if (!(user.getUserName().equalsIgnoreCase(inpUser) && user.getPassword().equals(inpPass))) {
					isValid = false;
					continue;
				}
				System.out.println();
				System.out.println("Welcome: " + user.getName());
				System.exit(1);

			}

			num++;
			if (isValid == false) {
				System.out.println();
				System.out.println("Invalid login, please try again");
				System.out.println();
			}
		}
		if (num == MAX_Attempts) {
			System.out.println("Too many failed login attempts, you are now locked out. ");
		}

	}// end main

	public static void loadUsers(int i, User[] users, BufferedReader br) throws IOException {
		String line = null;
		String[] lineData = null;
		while ((line = br.readLine()) != null) {
			lineData = line.split(",");
			User user = new User(lineData[0], lineData[1], lineData[2]);
			users[i] = user;
			i++;
		}
	}

} // end class
