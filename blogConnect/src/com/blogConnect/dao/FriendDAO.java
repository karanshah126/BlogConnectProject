package com.blogConnect.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class FriendDAO {

	@Autowired
	private NotificationDAO notificationDAO;
	private JdbcTemplate jdbcTemplate;
	
	DataSource dataSource;   
	
	public void setDataSource(DataSource dataSource) 
	{
	     this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addFriend(String userInSession, String friendname ) {
	
       String sql = "INSERT INTO friends values('"+userInSession+"','"+friendname+"')";
       String sql2 = "INSERT INTO friends values('"+friendname+"','"+userInSession+"')";
       
	        jdbcTemplate.update(sql);
	        jdbcTemplate.update(sql2);
	        
	        notificationDAO.removeRequest(userInSession, friendname);
	        
	}
	
	public void removeFriend(String userInSession, String friendname ) {
		
	       String sql = "DELETE from friends where username='"+userInSession+"' AND friendname='"+friendname+"'";
	       String sql2 = "DELETE from friends where friendname='"+userInSession+"' AND username='"+friendname+"'";
	       
		        jdbcTemplate.update(sql);
		        jdbcTemplate.update(sql2);
		        
		        notificationDAO.removeRequest(userInSession, friendname);
		        
		}
	
	
}
