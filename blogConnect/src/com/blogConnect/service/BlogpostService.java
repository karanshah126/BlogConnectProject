
package com.blogConnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogConnect.dao.BlogpostDAO;
import com.blogConnect.model.Blogpost;

public class BlogpostService {
	@Autowired
	BlogpostDAO blogpostDAO;
	
	
	 public String submitBlogpost(Blogpost blogpost) {  
		 
		 	blogpostDAO.insertBlogpost(blogpost);
			return "Blogpost submitted Sucessfully!";
			
		 } 
	 
	 public List<Blogpost> getPublicBlogpostList() {  
		  return blogpostDAO.getPublicBlogpostList(); 
		 }  
	 
	 public List<Blogpost> getPrivateBlogpostList(String sessionUsername) {  
		  return blogpostDAO.getPrivateBlogpostList(sessionUsername); 
		 } 
	
}