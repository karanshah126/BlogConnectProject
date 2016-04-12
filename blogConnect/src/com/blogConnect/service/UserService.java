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
		 
		if (userDAO.getUser(user).getEmail() !=null)
		{
			return "User already exists!";
		} 
		else
		{
			userDAO.insertData(user);
			return "Registered Sucessfully!";
		}
	 }
	 
	 
	 public List<User> getUserList() {  
	  return userDAO.getUserList();  
	 }  
	  
		// authenticate the login activity based on the login object
	 public String authenticateLogin(User user){
		 return userDAO.authenticateLogin(user);
	 }
	 
	 // get the user object based on the email
	 public User getUser(User user) {  
		  return userDAO.getUser(user);
	 }  
	
/*	 public void deleteData(String id) {  
	  userdao.deleteData(id);  
	    
	 }  
	  	 public User getUser(String id) {  
	  return userdao.getUser(id);  
	 }  

	 public void updateData(User user) {  
	  userdao.updateData(user);  
	    
	 }  
	  */
}
