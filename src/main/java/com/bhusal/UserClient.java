package com.bhusal;

import java.util.Scanner;

public class UserClient {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	while (true) {
	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	System.out.println("                   Welcome to User Management System                                    ");
	System.out.println("                   1. login                                                             ");
	System.out.println("                   2. Register                                                          ");
	System.out.println("                   3. Exit                                                              ");
	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	

	System.out.println("Choose one of the given options: ");
	int choice = scanner.nextInt();
	// use switch statement to deal with different cases
	switch (choice) {
	case 1:
		
		
		break;
	case 2:
		break;
	case 3:
		System.out.println("Thanks for using our service.");
		System.exit(0);

	default:
		System.out.println("please choose one value from 1 to 3.");
	} // end of switch

	}// end of while
	} // end of the method

}
