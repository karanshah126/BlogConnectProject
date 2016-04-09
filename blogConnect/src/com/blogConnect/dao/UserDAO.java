package com.blogConnect.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.blogConnect.model.User;

public class UserDAO {

	private JdbcTemplate jdbcTemplate;
	
	DataSource dataSource;   
	
	public void setDataSource(DataSource dataSource) {
	     this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	    //jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	public void insertData(User user) {
	
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
       String sql = "INSERT INTO user (firstName, lastName, email, username, password)"
	                    + " VALUES (?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(),
	                user.getEmail(), user.getUsername(), user.getPassword());

		
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	


	public User getUser(String username) {
		return null;
		
	}

}
