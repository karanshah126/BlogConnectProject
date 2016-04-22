package com.blogConnect.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blogConnect.model.Notification;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.BlogpostService;
import com.blogConnect.service.NotificationService;
import com.blogConnect.service.SearchService;
import com.blogConnect.service.UserService;

public class NotificationController {


	@Autowired	
	private NotificationService notificationService;
	@Autowired
	private BlogpostService blogpostService;
	@Autowired	
	private UserService userService;

    @RequestMapping(value = "/notifications", method = RequestMethod.POST)
	public ModelAndView redirectToNotifications(HttpSession session) {
   
    	UserSession userSession=(UserSession) session.getAttribute("session");
    	ModelAndView modelAndView = new ModelAndView("Notification");
       modelAndView.addObject("notificationList",notificationService.getUserNotificationList(userSession.getUsername()));
        return modelAndView; 
    }
    
    @RequestMapping(value = "/selectNotification", method = RequestMethod.POST)
	public ModelAndView goToUserPage(@RequestParam("sendername") String sendername,HttpSession session) {
   
    	UserSession userSession=(UserSession) session.getAttribute("session");
    	ModelAndView modelAndView = new ModelAndView("UserPage");
    	  modelAndView.addObject("userDetails",userService.getUser(sendername));
    	  modelAndView.addObject("blogpostList",blogpostService.getUserBlogpostList(sendername, userSession.getUsername()));
        return modelAndView; 
    }
    
}
