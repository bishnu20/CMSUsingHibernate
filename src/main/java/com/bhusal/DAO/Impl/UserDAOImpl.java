package com.bhusal.DAO.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bhusal.DAO.UserDAO;
import com.bhusal.config.HibernateConfig;
import com.bhusal.entiry.User;
import com.mysql.cj.Query;

public class UserDAOImpl implements UserDAO {

	public void register() {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyCredentials(String uname, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public User findUser(int id1) {
		Session session = HibernateConfig.config();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Users where id=id1");
		return null;
	}

	public List<User> users() {
		// TODO Auto-generated method stub
		return null;
	}



}
