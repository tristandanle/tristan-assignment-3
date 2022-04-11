package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {

		final int SIZE = 4; // there is four lines in a file
		final int MAX_Attempts = 5;
		int num = 1;
		int i = 0;
		boolean login = false;
		// boolean matched = false;
		//String line = null;
		//String[] lineData = null;
		User[] users = new User[SIZE];
		String inpUser = null;
		String inpPass = null;
		User userlog = new User();
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		Scanner scan = new Scanner(System.in);
		// Read user from file
		loadUsers(i, users, br);

		// Scan infos from keyboard
		inpUser = inputUsername(scan);
		System.out.println();
		inpPass = inputPassword(scan);
		while (num < MAX_Attempts) {
			for (User user : users) {
				userlog = user;
				if (userlog.getUserName().equalsIgnoreCase(inpUser) && userlog.getPassword().equals(inpPass)) {
					login = true;
					break;
				} else {
					continue;
				}
			}
                        // If user is logged successfully, print out the welcome and name
			if (login == true) {
				System.out.println();
				System.out.println("Welcome: " + userlog.getName());
				break;
			} else { // Display invalid message et re-input username and password 
				System.out.println();
				System.out.println("Invalid login, please try again");
				System.out.println();
				inpUser = inputUsername(scan);
				System.out.println();
				inpPass = inputPassword(scan);
				num++;
                                // Lock out user if the maximum (5) of login is reached
				if (num >= MAX_Attempts) {
					System.out.println();
					System.out.println("Too many failed login attempts, you are now locked out. ");
				}
			}

		}

	} // end main

	// Method of reading user's data file that is placed into the users's array
	public static void loadUsers(int i, User[] users, BufferedReader br) throws IOException {
		String line;
		String[] lineData;
		while ((line = br.readLine()) != null) {
			lineData = line.split(",");
			User user = new User(lineData[0], lineData[1], lineData[2]);
			users[i] = user;
			i++;
		}
	}
        // Method of inputting the user's password
	public static String inputPassword(Scanner scan) {
		String inpPass;
		System.out.println("Enter your password: ");
		System.out.println();
		inpPass = scan.nextLine();
		return inpPass;
	}
        // Method of inputting the user's username
	public static String inputUsername(Scanner scan) {
		String inpUser;
		System.out.println("Enter your email: ");
		System.out.println();
		inpUser = scan.nextLine();
		return inpUser;
	}
} // end class
