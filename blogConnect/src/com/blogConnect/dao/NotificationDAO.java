package com.blogConnect.dao;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.blogConnect.model.Notification;

public class NotificationDAO {

	private JdbcTemplate jdbcTemplate;
	
	DataSource dataSource;   
	
	public void setDataSource(DataSource dataSource) {
	     this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	    

	public void insertNotification(Notification notification) {
	
	   int count=1+ jdbcTemplate.queryForObject("SELECT COUNT(*) FROM notification", int.class);
       String sql = "INSERT INTO notification (notifid, type, content, sendername, receivername)"
	                    + " VALUES (?, ?, ?, ?, ?)";
       String sql2="INSERT INTO usernotification (username, notifid) VALUES (?, ?)";
       
  jdbcTemplate.update(sql ,count ,notification.getType(),notification.getContent(),notification.getSendername(), notification.getReceivername());		
		jdbcTemplate.update(sql2, notification.getReceivername(), notification.getNotifid());
	}
	
	public void removeRequest(String userInSession, String friendname)
	{
		String sql="DELETE from notification where type='connect' AND ((receivername='"
				+userInSession+"' AND sendername='"+friendname+"') OR (receivername='"
				+friendname+"' AND sendername='"+userInSession+"')";
		
        jdbcTemplate.update(sql);
	}

 
	public List<Notification> getUserNotificationList(String username) {
		

		  List<Notification> notificationList = new ArrayList<Notification>();  
		  String sql = "select * from notification where (select notifid from usernotification where username='"+username+"')";  
		  notificationList = jdbcTemplate.query(sql, new NotificationMapper());  
		
			  return notificationList;
	}
	
}