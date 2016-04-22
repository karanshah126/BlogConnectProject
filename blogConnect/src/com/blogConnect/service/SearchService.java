package com.blogConnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogConnect.dao.UserDAO;
import com.blogConnect.model.User;

public class SearchService {

	@Autowired
	UserDAO userDAO;
	
	 public List<User> getSearchResults(String searchString) {  
		  return userDAO.getSearchResults(searchString);  
		 }  
	
}
