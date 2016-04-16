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
       String sql2= "   Insert into friends values('"+user.getUsername()+"','"+user.getUsername()+"') ";
	        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(),
	                user.getEmail(), user.getUsername(), hashPassword(user.getPassword()));
	        jdbcTemplate.update(sql2);
	
	}
	
	  
	 private String hashPassword(String password) {  
		 
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
	  return passwordEncoder.encode(password);
	  
	 }  

	public User getUser(String emailORusername) {
		  
		User nullUser=new User();  
		nullUser.setEmail(null);
		nullUser.setFirstName(null);
		nullUser.setLastName(null);
		nullUser.setUsername(null);
		nullUser.setPassword(null);
		
		
		  List<User> userList = new ArrayList<User>();  
		  String sql = "select * from user where email='" + emailORusername
				  		+"' OR username='"+ emailORusername+"'";  
		  userList = jdbcTemplate.query(sql, new UserMapper());  
		  
			 
		  if(userList.size()==0)
			  return nullUser;
		  else
			  return userList.get(0);
		
	}
	 
	public String authenticateLogin(User user){
		String email = user.getEmail();
		String password = user.getPassword();
		String storedPassword = getUser(email).getPassword();
	
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 

		
		if (storedPassword==null){
			return "User does not Exist. Wrong Email, Please Try Again.";
		}
		else if (passwordEncoder.matches(password, storedPassword)){
			return "success";
		}
		else {
			return "Wrong password entered.";
		}
	}

	 

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}




}
