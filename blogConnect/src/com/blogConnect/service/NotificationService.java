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
		
		
		if (notification.getType().equals("connect"))
		{
			notificationDAO.insertNotification(notification);
			return "Request to connect sent.";
		}
		else
		{
			String r=friendStatus(notification.getSendername(),notification.getReceivername());
			if(r.equals("Connected")||r.equals("Your Profile"))
				{notificationDAO.insertNotification(notification);
			return "Message sent.";}
			else
				return "This user is not your Friend. Cannot send message.";
		}
	}
	
	public String friendStatus(String userInSession,String username){
		
		return userDAO.friendStatus(userInSession, username);
	}
	 
	public List<Notification> getUserNotificationList(String username) {

		  return notificationDAO.getUserNotificationList(username);  
		  
		 } 
	 

	
}
