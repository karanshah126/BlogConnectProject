package com.blogConnect.dao;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import org.springframework.jdbc.core.RowMapper;

import com.blogConnect.model.Notification;


	public class NotificationMapper implements RowMapper<Notification> {
	   public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
	     Notification notification=new Notification();
	     
	     notification.setNotifid(rs.getInt("notifid"));
	     notification.setType(rs.getString("type"));
	     notification.setContent(rs.getString("content"));
	     notification.setSendername(rs.getString("sendername"));
	     notification.setReceivername(rs.getString("receivername"));
	      return notification;
	   }
	}
