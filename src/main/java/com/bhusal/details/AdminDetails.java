package com.bhusal.details;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.bhusal.UserClient;
import com.bhusal.DAO.Impl.UserDAOImpl;
import com.bhusal.config.HibernateConfig;
import com.bhusal.entity.User;

public class AdminDetails {
	public void adminMenu() {
		Scanner scanner = new Scanner(System.in);
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		Session session = HibernateConfig.config();
		while(true) {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("                     Admin Details Main Page                               ");
			System.out.println("                         1. Register a User                                ");
			System.out.println("                         2. View A User Info                               ");
			System.out.println("                         3. View All Users                                  ");
			System.out.println("                         4. Update A User Info                              ");
			System.out.println("                         5. Delete User                                    ");
			System.out.println("                         6. Log Out                                        ");
			System.out.println("                         7. Exit                                           ");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println(" Choose one of the above options: ");
			int input = scanner.nextInt();
			//use switch to deal with different cases
			switch (input) {
			case 1:
				// registers a user
				userDAOImpl.register();
				break;
			case 2:
				// shows a user info corresponding its id
				System.out.println("Enter User id: ");
				int id = scanner.nextInt();
				User user = userDAOImpl.findUser(id);
				if (user != null) {
					System.out.println(user.getFirstName()+ "\t"+ user.getLastName() + "\t"+ user.getEmail() + "\t"+ user.getAddress());
				}
				else {
					System.out.println("User information does not exit.");
				}
			
				break;
			case 3:
				// returns all uses in the system.
				List<User> userList =  userDAOImpl.users();
				if (userList.size()>0) {
					for(User p:userList) {
						System.out.println(p.getFirstName()+ "\t"+ p.getLastName() + "\t"+ p.getEmail() + "\t"+ p.getAddress());
					}
					
				}else {
					System.out.println("User list is empty.");
				}
				break;
			case 4: 
				// update a user
				System.out.println("Enter id: ");
				userDAOImpl.updateUser(scanner.nextInt());
				System.out.println("User is successfully updated.");			
				break;
			case 5:
				//deletes a user
				System.out.println("Enter id: ");
				userDAOImpl.delete(scanner.nextInt());
				System.out.println("Used is successfully deleted.");
				break;
			case 6:
					UserClient.main(null);
			case 7:
				System.out.println("Thanks for using service.");
				System.exit(0);

			default:
				System.out.println("Please choose one option from 1 to 6.");
			} // end of switch
			
		} // end of while
		
	}

}
