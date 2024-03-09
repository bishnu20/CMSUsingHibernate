/*
 * Coder: Bishnu Bhusal
   Topic: Customer Management System Using Hibernate
   */
package com.bhusal;

import java.util.Scanner;

import com.bhusal.DAO.Impl.UserDAOImpl;
import com.bhusal.details.AdminDetails;
import com.bhusal.details.UserDetails;

public class UserClient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserDetails userDetails = new UserDetails();
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		AdminDetails adDetails = new AdminDetails();
		while (true) {
			System.out.println(
					"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(
					"                   Welcome to User Management System                                    ");
			System.out.println(
					"                   1. User login                                                             ");
			System.out.println(
					"                   2. Admin login                                                             ");
			System.out.println(
					"                   3. Register                                                          ");
			System.out.println(
					"                   4. Forgot password                                                    ");
			System.out.println(
					"                   5. Exit                                                              ");
			System.out.println(
					"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

			System.out.println("Choose one of the given options: ");
			int choice = scanner.nextInt();
			// use switch statement to deal with different cases
			switch (choice) {
			case 1:
				System.out.println("Enter user name: ");
				String uName = scanner.next();
				System.out.println("Enter password: ");
				String pass = scanner.next();
				if (userDAOImpl.verifyCredentials(uName, pass)) {
					System.out.println("You are logged in as an user.");
					userDetails.uDetails();
				}

				break;
			case 2:
				System.out.println("Enter user name: ");
				String uName1 = scanner.next();
				System.out.println("Enter password: ");
				String pass1 = scanner.next();
				if (uName1.equals("admin") && pass1.equals("123")) {
					System.out.println("Welcome admin: ");
					adDetails.adminMenu();
				}
				break;
			case 3:
				userDAOImpl.register();
				System.out.println("You are successfully registered.");
				break;
		    case 4: 
		    	System.out.println("Enter your user name: ");
		    	String userName = scanner.next();
		    	System.out.println("Enter your email:");
		    	String email = scanner.next();
		    	userDAOImpl.resetPassword(userName, email);
					break;
			case 5:
				System.out.println("Thanks for using our service.");
				System.exit(0);

			default:
				System.out.println("please choose one value from 1 to 3.");
			} // end of switch

		} // end of while
	} // end of the method

}
