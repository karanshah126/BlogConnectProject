package com.blogConnect.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blogConnect.model.Blogpost;
import com.blogConnect.model.Notification;
import com.blogConnect.model.User;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.BlogpostService;
import com.blogConnect.service.FriendService;
import com.blogConnect.service.NotificationService;
import com.blogConnect.service.UserService;

public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private BlogpostService blogpostService;
	@Autowired
	private FriendService friendService;
	
	@RequestMapping(value = "/messageUser", method = RequestMethod.POST)
	public ModelAndView sendingMessage(@ModelAttribute Notification notification,  HttpSession session){ 
		
		UserSession userSession=(UserSession) session.getAttribute("session");
		 notification.setType("message");
		 notification.setSendername(userSession.getUsername());
		 	
		String result= notificationService.insertNotification(notification);
		 
    	ModelAndView modelAndView = new ModelAndView("UserPage","notifyMessage", result);
  	  modelAndView.addObject("userDetails",userService.getUser(notification.getReceivername()));
  	  modelAndView.addObject("blogpostList",blogpostService.getUserBlogpostList(notification.getReceivername(), userSession.getUsername()));
			return modelAndView;
		}
	
	@RequestMapping(value = "/connectRequest", method = RequestMethod.POST)
	public ModelAndView sendingFriendRequest(@ModelAttribute Notification notification,  HttpSession session){ 
		
		UserSession userSession=(UserSession) session.getAttribute("session");
		 notification.setType("connect");
		 notification.setSendername(userSession.getUsername());
		 notification.setContent(userSession.getUsername()+" has requested to connect with you.");
		 	
		String result= notificationService.insertNotification(notification);
		 
    	ModelAndView modelAndView = new ModelAndView("UserPage","notifyMessage", result);
  	  modelAndView.addObject("userDetails",userService.getUser(notification.getReceivername()));
  	  modelAndView.addObject("blogpostList",blogpostService.getUserBlogpostList(notification.getReceivername(), userSession.getUsername()));
			return modelAndView;
		}
	
	@RequestMapping(value = "/respondToRequest", method = RequestMethod.GET)
	public ModelAndView respondFriendRequest(@RequestParam("username") String username,  HttpSession session){ 
		
		
		UserSession userSession=(UserSession) session.getAttribute("session");
		friendService.connectUser(userSession.getUsername(),username);
		 	
		String result= "This user is now connected with you";
		 
    	ModelAndView modelAndView = new ModelAndView("UserPage","notifyMessage", result);
  	  modelAndView.addObject("userDetails",userService.getUser(username));
  	  modelAndView.addObject("blogpostList",blogpostService.getUserBlogpostList(username, userSession.getUsername()));
			return modelAndView;
		}
}
