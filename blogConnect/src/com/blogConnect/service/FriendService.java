package com.blogConnect.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogConnect.dao.FriendDAO;
import com.blogConnect.dao.NotificationDAO;

public class FriendService {


	@Autowired
		FriendDAO friendDAO;
	@Autowired
	NotificationDAO notificationDAO;
	public String connectUser(String userInSession,String friendname) {
		friendDAO.addFriend(userInSession, friendname);
		notificationDAO.removeRequest(userInSession, friendname);
		return "User Connected";
	}
	
	
	
}
