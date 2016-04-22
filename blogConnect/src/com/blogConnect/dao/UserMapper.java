
package com.blogConnect.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.blogConnect.model.User;


public class UserMapper implements RowMapper<User> {
   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
     User user=new User();
     
     user.setEmail(rs.getString("email"));
     user.setFirstName(rs.getString("firstName"));
	user.setLastName(rs.getString("lastName"));
	user.setPassword(rs.getString("password"));
	user.setUsername(rs.getString("username"));

	user.setBio(rs.getString("bio"));
	user.setGender(rs.getString("gender"));
	user.setBirthdate(rs.getString("username"));
	user.setProfilePicture(rs.getString("profilePicture"));

	
      return user;
   }
}
