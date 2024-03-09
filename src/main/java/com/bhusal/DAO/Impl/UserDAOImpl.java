package com.bhusal.DAO.Impl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jvnet.staxex.util.XMLStreamReaderToXMLStreamWriter;

import com.bhusal.DAO.UserDAO;
import com.bhusal.config.HibernateConfig;
import com.bhusal.entity.User;

public class UserDAOImpl implements UserDAO {
	Session session = HibernateConfig.config();
	Scanner scanner = new Scanner(System.in);

	public void register() {
		// this method will register the user and saves in the database
		Transaction tx = session.beginTransaction();		
		System.out.println("Enter first name: ");
		String firstName = scanner.next();
		System.out.println("Enter last name: ");
		String lname = scanner.next();
		System.out.println("Enter address : ");
		String address = scanner.next();
		System.out.println("Enter email: ");
		String email = scanner.next();
		System.out.println("Enter user name: ");
		String uName = scanner.next();
		System.out.println("Enter password: ");
		String password = scanner.next();
		User user = new User(firstName,lname,address,email,uName,password);
		session.persist(user);
		tx.commit();			
	}
	// This method will check credentials

	public boolean verifyCredentials(String uname, String pass) {
		boolean result = false;
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User where username=:name and password=:pa");
		query.setParameter("name", uname);
		query.setParameter("pa", pass);
		
		try {
			User user = (User) query.getSingleResult();
			if (user != null) {
				result = true;		
			}	
			
		} catch (NoResultException e) {
			System.out.println("invalid credentials.");
		}
		
		transaction.commit();
	
		return result;
	}

	public User findUser(int id1) {	
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from User where id=:val");
		query.setParameter("val", id1);
		User user = (User) query.getSingleResult();
		tx.commit();
		return  (User) user;
	
	}

	public List<User> users() {
		// This will return all the users
		//Session session = HibernateConfig.config();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> users =  query.getResultList();
		transaction.commit();
		return users;
	}
	public void updateUser(int id) {
		Transaction tx = session.beginTransaction();
		System.out.println("Enter user id: ");
		Integer uid = scanner.nextInt();
		Query userQuery = session.createQuery("from User where id=:userId");
		userQuery.setParameter("userId", uid);
		User user = (User) userQuery.getSingleResult();
		if(user != null) {
			System.out.println("Enter first name: ");
			String firstName = scanner.next();
			user.setFirstName(firstName);
			System.out.println("Enter last name: ");
			String lastName = scanner.next();
			user.setLastName(lastName);
			System.out.println("Enter address: ");
			String address = scanner.next();
			user.setAddress(address);
			// save the user
			session.persist(user);
			tx.commit();
		} else {
			System.out.println("No record exits with that id.");
		}
		
	}

	public void delete(int uId) {
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from User where id=:val");
		q.setParameter("val", uId);
		User user = (User) q.getSingleResult();
		if(user != null) {
			session.remove(user);
			System.out.println("User is successfully removed.");
			// this will close the session
			tx.commit();
			
		}else {
			System.out.println("User does not exit with that id.");
		} // end of else				
		
	}// end of method
	public void resetPassword(String uname, String email) {
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User where email=:em and username=:u");
		query.setParameter("em", email);
		query.setParameter("u", uname);
		//List<Object> objects =  query.getResultList();
		User user = (User) query.getSingleResult();
		if(user!=null) {
			System.out.println("Enter your new password: ");
			user.setPassword(scanner.next());
			session.persist(user);
			transaction.commit();
			System.out.println("Password is successfully updated.");
		}else {
			System.out.println("User name and email did not match in our records.");
		}
		
	} // end of reset password

} // end of the class
