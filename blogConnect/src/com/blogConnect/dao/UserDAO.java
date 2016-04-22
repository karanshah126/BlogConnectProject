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
	
	
	public void updateInfoSettings(User user,String UserName) {
		
	       String sql = "UPDATE user SET firstName='"+user.getFirstName()+"', lastName='"+user.getLastName()
	       +"', bio='"+user.getBio()+"', gender='"+user.getGender()+"', birthdate='"+user.getBirthdate()+
	       "', profilePicture='"+user.getProfilePicture()+"' WHERE username='"+UserName+"'";

		        jdbcTemplate.update(sql);
		
		}
	
	public void resetPassword(String newPassword, String username)
	{
		String sql="UPDATE user SET password='"+hashPassword(newPassword)+"' WHERE username='"+username+"'";
		jdbcTemplate.update(sql);
	}

	public String friendStatus(String userInSession,String UserName) {
		
		
		String sql1="SELECT Count(*) from friends where (username='"+userInSession+"' AND friendname='"+UserName
					+"') OR (friendname='"+userInSession+"' AND username='"+UserName+"')";
		
		String sql2="Select Count(*) from notification where sendername='"+userInSession
				+"' AND type='friendrequest' AND receivername='"+UserName+"'";
		String sql3="Select Count(*) from notification where sendername='"+UserName
				+"' AND type='friendrequest' AND receivername='"+userInSession+"'";
		
		   int checkIfFriend=jdbcTemplate.queryForObject(sql1,int.class);
		   int checkIfReqSent=jdbcTemplate.queryForObject(sql2,int.class);
		   int checkIfReqReceived=jdbcTemplate.queryForObject(sql3,int.class);
		   
		   if(checkIfFriend>0)
			   return "Already Connected";
		   else if(checkIfReqSent>0)
			   return "Request to connect already sent";
		   else if(checkIfReqReceived>0)
			   return "Request to connect received";
		   else
			   return "Not connected";
		   
		}

	public List<User> getSearchResults(String searchString) {
		
		  List<User> resultList = new ArrayList<User>();  
		  String searchStringLower=searchString.toLowerCase();
		  
		  String sql = "select user.* from user inner join userfullname on user.username=userfullname.username "
				  		+"where user.email='" + searchStringLower
				  		+"' OR user.username='"+ searchStringLower
				  		+"' OR lower(firstName)='"+ searchStringLower
				  		+"' OR lower(lastName)='"+ searchStringLower
				  		+"' OR userfullname.fullname='"+searchStringLower+"'";
		  
		  resultList = jdbcTemplate.query(sql, new UserMapper());  
		
		return resultList;
	}




}
