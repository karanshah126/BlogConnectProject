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
	
       String sql = "INSERT INTO user (firstName, lastName, email, username, password, usertype, profilePicture)"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
       String sql2= "   Insert into friends values('"+user.getUsername()+"','"+user.getUsername()+"') ";
	        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(),
	                user.getEmail(), user.getUsername(), hashPassword(user.getPassword()), "public", "http://i.imgur.com/NyQn3wO.png");
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
	       +"', bio='"+user.getBio()+"', profilePicture='"+user.getProfilePicture()+"' WHERE username='"+UserName+"'";

		        jdbcTemplate.update(sql);
		
		}
	
	public void updatePrivacySettings(String usertype,String UserName) {
		
	       String sql = "UPDATE user SET usertype='"+usertype+"' WHERE username='"+UserName+"'";

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
				+"' AND type='connect' AND receivername='"+UserName+"'";
		String sql3="Select Count(*) from notification where sendername='"+UserName
				+"' AND type='connect' AND receivername='"+userInSession+"'";
		
		   int checkIfFriend=jdbcTemplate.queryForObject(sql1,int.class);
		   int checkIfReqSent=jdbcTemplate.queryForObject(sql2,int.class);
		   int checkIfReqReceived=jdbcTemplate.queryForObject(sql3,int.class);
		   
		   System.out.println("checkIfFriend :"+checkIfFriend);
		   System.out.println("checkIfReqSent:"+checkIfReqSent);
		   System.out.println("checkIfReqReceived: "+checkIfReqReceived);
		   
		   
		   if(checkIfFriend==1)
			   return "Your Profile";
		   else if(checkIfFriend==2)
			   return "Connected";
		   else if(checkIfReqSent>0)
			   return "Connect Request Sent";
		   else if(checkIfReqReceived>0)
			   return "Respond to Connect Request";
		   else
			   return "Connect";
		   
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
