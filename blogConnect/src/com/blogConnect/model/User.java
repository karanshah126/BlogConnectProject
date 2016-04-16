package com.blogConnect.model;

import java.util.List;

public class User 
	{  
		  
		 private String username;  
		 private String firstName;  
		 private String lastName;  
		 private String password;  
		 private String email;
		 private List<User> friendlist;
		 
		  
		 public String getUsername() {  
		  return username;  
		 }  
		  
		 public void setUsername(String username) {  
		  this.username = username;  
		 }  
		  
		 public String getFirstName() {  
		  return firstName;  
		 }  
		  
		 public void setFirstName(String firstName) {  
		  this.firstName = firstName;  
		 }  
		  
		 public String getLastName() {  
		  return lastName;  
		 }  
		  
		 public void setLastName(String lastName) {  
		  this.lastName = lastName;  
		 }  
		  
		 public String getPassword() {  
		  return password;  
		 } 
		  
		 public void setPassword(String password) {  
		  this.password = password;  
		 }  
		  
		 public String getEmail() {  
		  return email;  
		 }  
		  
		 public void setEmail(String Email) {  
		  this.email = Email;  
		 }  
	}  

