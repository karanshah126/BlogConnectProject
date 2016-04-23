package com.blogConnect.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blogConnect.model.Notification;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.BlogpostService;
import com.blogConnect.service.FriendService;
import com.blogConnect.service.NotificationService;
import com.blogConnect.service.UserService;

@Controller
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
  	 modelAndView.addObject("connectStatus", userService.friendStatus(userSession.getUsername(), notification.getReceivername()));
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
	  modelAndView.addObject("connectStatus", userService.friendStatus(userSession.getUsername(), notification.getReceivername()));
  	  modelAndView.addObject("blogpostList",blogpostService.getUserBlogpostList(notification.getReceivername(), userSession.getUsername()));
			return modelAndView;
		}
	
	@RequestMapping(value = "/respondToRequest", method = RequestMethod.POST)
	public ModelAndView respondFriendRequest(HttpServletRequest request,  HttpSession session){ 
		
		
		UserSession userSession=(UserSession) session.getAttribute("session");
		String username=request.getParameter("username");
		friendService.connectUser(userSession.getUsername(),username);
		 	
		String result= "This user is now connected with you";
		 
    	ModelAndView modelAndView = new ModelAndView("UserPage","notifyMessage", result);
  	  modelAndView.addObject("userDetails",userService.getUser(username));
	  modelAndView.addObject("connectStatus", userService.friendStatus(userSession.getUsername(), username));
  	  modelAndView.addObject("blogpostList",blogpostService.getUserBlogpostList(username, userSession.getUsername()));
			return modelAndView;
		}
	
	@RequestMapping(value = "/unconnect", method = RequestMethod.POST)
	public ModelAndView removeFriend(HttpServletRequest request,  HttpSession session){ 
		
		
		UserSession userSession=(UserSession) session.getAttribute("session");
		String username=request.getParameter("username");
		friendService.unconnectUser(userSession.getUsername(),username);
		 	
		String result= "This user is now not connected with you";
		 
    	ModelAndView modelAndView = new ModelAndView("UserPage","notifyMessage", result);
  	  modelAndView.addObject("userDetails",userService.getUser(username));
	  modelAndView.addObject("connectStatus", userService.friendStatus(userSession.getUsername(), username));
  	  modelAndView.addObject("blogpostList",blogpostService.getUserBlogpostList(username, userSession.getUsername()));
			return modelAndView;
		}
	
	
	
}
