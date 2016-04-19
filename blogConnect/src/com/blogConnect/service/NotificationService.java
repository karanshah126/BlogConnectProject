package com.blogConnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogConnect.dao.NotificationDAO;
import com.blogConnect.model.Notification;;

public class NotificationService {

	@Autowired
	 NotificationDAO notificationDAO;
	public String insertNotification(Notification notification) {
		notificationDAO.insertNotification(notification);
		
		if (notification.getType().equals("connect"))
			return "Request to connect sent.";
		else
			return "Message sent.";
	}
	 
	public List<Notification> getUserNotificationList(String username) {

		  return notificationDAO.getUserNotificationList(username);  
		  
		 } 
	 

	
}
