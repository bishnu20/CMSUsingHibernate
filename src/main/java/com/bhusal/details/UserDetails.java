package com.bhusal.details;

import java.util.Scanner;

import com.bhusal.UserClient;
import com.bhusal.DAO.Impl.UserDAOImpl;
import com.bhusal.entity.User;

public class UserDetails {
	
	public void uDetails() {
		Scanner scanner = new Scanner(System.in);
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		while(true) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                           User Details Main Page                               ");
			System.out.println("                         1. See User Info                                       ");
			System.out.println("                         2. Delete User Info                                    ");
			System.out.println("                         3. Log Out                                       ");
			System.out.println("                         4. Exit                                                ");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println(" Choose one of the above options: ");
			int input = scanner.nextInt();
			//use switch to deal with different cases
			switch (input) {
			case 1:
				System.out.println("Enter your id: ");
				int id = scanner.nextInt();
				User user = userDAOImpl.findUser(id);
				if (user != null) {
					System.out.println(user.getFirstName()+ "\t"+ user.getLastName() + "\t"+ user.getEmail() + "\t"+ user.getAddress());
				}
				else {
					System.out.println("User information does not exit.");
				}
			
				break;
			case 2:
				System.out.println("Please contact our office to delete your information.");
				break;
				case 3:
					UserClient.main(null);
					break;
			case 4:
				System.out.println("Thanks for using service.");
				System.exit(0);

			default:
				System.out.println("Please choose one option from 1 to 3.");
			} // end of switch
			
		} // end of while
		

	} // end of the method

}
