package com.bhusal.DAO;

import java.util.List;

import com.bhusal.entity.User;

public interface UserDAO {
	public void register();
	//public void login(String uname,String password);
	public boolean verifyCredentials(String uname,String password);
	public User findUser(int id);
	public List<User> users();
	public void resetPassword(String uname, String email);

}
