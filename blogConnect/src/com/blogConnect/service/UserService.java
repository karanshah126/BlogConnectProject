package com.blogConnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogConnect.dao.UserDAO;
import com.blogConnect.model.User;

public class UserService {

	@Autowired
	 UserDAO userDAO;  
	
	
	 
	 public void insertData(User user) {
		 
	  userDAO.insertData(user);  
	 }  
	  
	 public List<User> getUserList() {  
	  return userDAO.getUserList();  
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
