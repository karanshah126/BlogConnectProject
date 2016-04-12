package com.blogConnect.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.blogConnect.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;  

public class UserDAO {

	private JdbcTemplate jdbcTemplate;
	
	DataSource dataSource;   
	
	public void setDataSource(DataSource dataSource) {
	     this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	    //jdbcTemplate = new JdbcTemplate(dataSource);
	}
	    

	public void insertData(User user) {
	
       String sql = "INSERT INTO user (firstName, lastName, email, username, password)"
	                    + " VALUES (?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(),
	                user.getEmail(), user.getUsername(), user.getPassword());
	
	}
	
	  
	 private String getHashPassword(String password) {  
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
	  String hashedPassword = passwordEncoder.encode(password);  
	  
	  System.out.println(hashedPassword);  
	  return hashedPassword;  
	 }  

	public User getUser(User user) {
		  
		User queryResult=new User();  
		queryResult.setEmail(null);
		queryResult.setFirstName(null);
		queryResult.setLastName(null);
		queryResult.setUsername(null);
		queryResult.setPassword(null);
		
		
		  List<User> userList = new ArrayList<User>();  
		  String sql = "select * from user where email='" + user.getEmail()+"'";  
		  userList = jdbcTemplate.query(sql, new UserMapper());  
		  if(userList.size()==0)
			  return queryResult;
		  else
			  return userList.get(0);
		
	}
	 
	public String authenticateLogin(User user){
		String email = user.getEmail();
		String password = user.getPassword();
		
		
		
		//String sql = "SELECT password FROM user WHERE user.email = ?" ;
		String storedPassword = getUser(user).getPassword();//this.jdbcTemplate.queryForObject(sql,new Object[]{email},String.class);
		// user does not exist

		System.out.println("password: '"+password+"'");
		System.out.println("Stored password: '"+storedPassword+"'");
		System.out.println(storedPassword==null);
		if (storedPassword==null){
			return "user does not exist";
		}
		// password matches
		else if (storedPassword.equals(password)){
			return "success";
		}
		//
		else {
			return "wrong password";
		}
	}

	 

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}




}
