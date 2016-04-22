package com.blogConnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogConnect.dao.UserDAO;
import com.blogConnect.model.User;

public class UserService {

	@Autowired
	 UserDAO userDAO;  
	
	
	 
	 public String registerUser(User user)
	 {
		 
		if (getUser(user.getEmail()).getEmail() !=null )
		{
			System.out.println(getUser(user.getEmail()));
			return "Email Address already exists! Please enter a different one.";
		} 
		
		else if (getUser(user.getUsername()).getUsername() !=null )
		{
			return "Username already exists! Please enter a different one.";
		} 
		
		else
		{
			userDAO.insertData(user);
			return "Registered Sucessfully!";
		}
	 }
	 
	 public User getUser(String emailORUsername) {  
		  return userDAO.getUser(emailORUsername);  
		 }
	 
	 public String updateInfoSettings(User user, String username) { 

		  userDAO.updateInfoSettings(user,username);  
		  return "Information Updated";
		 } 
	 
	 public void resetPassword(String password, String userInSession)
	 {
		 userDAO.resetPassword(password, userInSession);
		 System.out.println("In User service: password reset");
	 }
	 
	 public String authenticateLogin(User user){
		 return userDAO.authenticateLogin(user);
	 }
	 
 
	

}
