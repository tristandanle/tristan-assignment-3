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
		Scanner scan = new Scanner(System.in);
		
		// Read users from file
		loadUsers(i, users, br);

		
		while (num < MAX_Attempts) {
			// Scan infos from keyboard
			System.out.println("Enter your email: ");
			System.out.println();
			String inpUser = scan.nextLine();
			System.out.println("Enter your password: ");
			System.out.println();
			String inpPass = scan.nextLine();
			
			for (User user : users) {
//				System.out.println(user.getUserName());
//				System.out.println(user.getPassword());
				if (!(user.getUserName().equalsIgnoreCase(inpUser) && user.getPassword().equals(inpPass))) {
					//System.out.println("Invalid login, please try again");
					continue;
				} 				
					System.out.println("Welcome: " + user.getName());
					System.exit(1);
				
			}

			num++;
			//System.out.println(num);
			}
			if (num == MAX_Attempts ) {
				System.out.println();
				System.out.println("Too many failed login attempts, you are now locked out. ");
			}
	     
	    }// end main
		

	

	public static void loadUsers(int i, User[] users, BufferedReader br) throws IOException {
		String line=null;
		String[] lineData= null;
		while ((line = br.readLine()) != null) {
			lineData = line.split(",");
			User user = new User(lineData[0], lineData[1], lineData[2]);
			users[i] = user;
			i++;
		}
	}

	
} // end class

