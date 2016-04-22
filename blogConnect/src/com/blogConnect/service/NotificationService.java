package com.blogConnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogConnect.dao.NotificationDAO;
import com.blogConnect.dao.UserDAO;
import com.blogConnect.model.Notification;;

public class NotificationService {

	@Autowired
	 NotificationDAO notificationDAO;
	@Autowired
	UserDAO userDAO;
	public String insertNotification(Notification notification) {
		notificationDAO.insertNotification(notification);
		
		if (notification.getType().equals("connect"))
			return "Request to connect sent.";
		else
			return "Message sent.";
	}
	
	public String friendStatus(String userInSession,String username){
		
		return userDAO.friendStatus(userInSession, username);
	}
	 
	public List<Notification> getUserNotificationList(String username) {

		  return notificationDAO.getUserNotificationList(username);  
		  
		 } 
	 

	
}
